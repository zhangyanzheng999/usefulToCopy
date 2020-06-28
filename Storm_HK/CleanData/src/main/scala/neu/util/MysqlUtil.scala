package neu.util

import java.sql.DriverManager

object MysqlUtil extends Serializable{
  def createConn() = {
    Class.forName("com.mysql.jdbc.Driver")
    DriverManager.getConnection("jdbc:mysql://172.16.29.70:3306/zyztenmindata_original?characterEncoding=utf8&useSSL=false","root","123456")
  }


}
