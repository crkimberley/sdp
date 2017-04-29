package alarm

abstract class Sensor(location: String) {

  def isTriggered: Boolean

  def getLocation = location

  def getSensorType: String

  def getSensorCategory: String

  //def getBatteryPercentage: Double
}
