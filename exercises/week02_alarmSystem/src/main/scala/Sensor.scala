import SensorCategory.SensorCategory

trait Sensor {
  def isTriggered: Boolean

  def getLocation: String

  def getSensorType: String

  def getSensorCategory: SensorCategory

  //def getBatteryPercentage: Double
}
