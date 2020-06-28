package neu.bean


import java.text.SimpleDateFormat

class fanData(date: String, windSpeed: String, power: String,maxSpeed:Double,minSpeed:Double,maxPower:Double,minPower:Double) {


  def isValid(): Boolean = {
    val time: Double = System.currentTimeMillis()
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val curdate = dateFormat.format(time).toString.substring(0, 10)
    if(date.substring(0, 10).replaceAll("/","-").equals(curdate) &&
      windSpeed != null && windSpeed.length > 0 &&
      windSpeed.toDouble <= maxSpeed && windSpeed.toDouble >= minSpeed &&
      power != null && power.length > 0 &&
      power.toDouble >= (minPower) && power.toDouble <= maxPower) {
      true
    } else {
      false
    }
  }


}

object fanData {
  def main(args: Array[String]): Unit = {
    println(new fanData("2016-03-25", null, "5",0,10,0,10).isValid())
  }
}