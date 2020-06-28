package neu


import java.sql.{Connection, ResultSet}
import java.text.SimpleDateFormat

import neu.bean.fanData
import neu.util.{HbaseUtil, MyKafkaUtil, MysqlUtil}
import org.apache.hadoop.hbase.TableName
import org.apache.hadoop.hbase.client.Put
import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable.ArrayBuffer

object CleanKafkaData {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setAppName("CleanData")
      .setMaster("local[*]")
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("spark.sql.shuffle.partitions", "4")
    val ssc = new StreamingContext(conf, Seconds(5))

    /**
     * 这里为了读取数据库内容防止重复读取
     */
    val conn: Connection = MysqlUtil.createConn()
    val rs: ResultSet = conn.createStatement().executeQuery("select * from rule limit 1")
    var minSpeed: Double = 3
    var maxSpeed: Double = 12
    var minPower: Double = -750
    var maxPower: Double = 750

    while (rs.next()) {
      maxSpeed = rs.getDouble("MAX_SPEED")
      minSpeed = rs.getDouble("MIN_SPEED")
      maxPower = rs.getDouble("MAX_POWER")
      minPower = rs.getDouble("MIN_POWER")
    }


    val KafkaDStream = MyKafkaUtil.getKafkaSteam(ssc, "zyzStorm")
      //分类
      .mapPartitions(it => {
        var arr: ArrayBuffer[(Int, String)] = ArrayBuffer[(Int, String)]()
        while (it.hasNext) {
          val record = it.next().value()
          val vals: Array[String] = record.split(",")
          //判断数据是否符合要求，符合为0，不符合标位1
          if (new fanData(vals(2), vals(4), vals(22), maxSpeed, minSpeed, maxPower, minPower).isValid()) {
            arr += Tuple2(0, record)
          } else {
            arr += Tuple2(1, record)
          }
        }
        arr.iterator
      })

    //把数据写入到Hbase，其中._1==0写道normal ._1==1写到Abnormal
    KafkaDStream.foreachRDD(rdd => {
      if (!rdd.isEmpty()) {
        rdd.foreachPartition((partition: Iterator[(Int, String)]) => {
          if (!partition.isEmpty) {
            //partition和record共同位于本地计算节点Worker，故无需序列化发送conn和statement
            //如果多个分区位于一个Worker中，则共享连接（位于同一内存资源中）
            //获取HBase连接
            val conn = HbaseUtil.getHBaseConn
            if (conn == null) {
              println("conn is null.") //在Worker节点的Executor中打印
            } else {
              partition.foreach((record: (Int, String)) => {
                val rowkey = record._2.split(",")(2) + "_" + record._2.split(",")(1)
                if (record._1 == 0) {
                  val tableName = TableName.valueOf("zyzNormal")
                  val table = conn.getTable(tableName)
                  //设置rowkey
                  val put = new Put(Bytes.toBytes(s"$rowkey"))
                  //三个参数：列族、列、列值
                  put.addColumn(Bytes.toBytes("date_fanNo"),
                    Bytes.toBytes(record._2.split(",")(1)),
                    Bytes.toBytes(record._2))
                  //执行插入
                  table.put(put)
                } else {
                  //设置表名 正常和不正常
                  val tableName = TableName.valueOf("zyzAbnormal")
                  val table = conn.getTable(tableName)
                  val put = new Put(Bytes.toBytes(s"$rowkey"))
                  put.addColumn(Bytes.toBytes("date_fanNo"),
                    Bytes.toBytes(record._2.split(",")(1)),
                    Bytes.toBytes(record._2))
                  table.put(put)
                }
              })
            }
          }
        })
      }
    })


    val dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val countDStream: DStream[(String, Int)] = KafkaDStream
      .filter(_._1 == 0)
      .mapPartitions(it => {
        val arr: ArrayBuffer[(String, Int)] = ArrayBuffer[(String, Int)]()
        while (it.hasNext) {
          val record = it.next()._2.split(",")
          if (record(13).toDouble > 30) { //测试生成数据是暂时设置一个较低的，最后改为80
            arr += Tuple2(record(1), 1)
          } else {
            arr += Tuple2(record(1), 0)
          }
        }
        arr.iterator
      })
      .reduceByKeyAndWindow((a: Int, b: Int) => a + b, Seconds(30), Seconds(5))

    countDStream.print()

    countDStream
      //(编号，次数)
      .foreachRDD(rdd => {
        //报警信息写到mysql
        rdd.foreachPartition(part => {
          val conn = MysqlUtil.createConn()
          part.foreach(record => {
            if (record._2 > 5) {
              val time: String = dateFormat.format(System.currentTimeMillis()) //当前报警时间
              val sql = "insert into info(fan_no,time,count) values ('" + record._1 + "'," + "'" + time + "'," + record._2 + ")" // executed at the worker
              conn.createStatement().execute(sql)
            }
          })
          //conn.close()
        })
      })


    ssc.start()
    ssc.awaitTermination()
  }


}
