class SmokeSensor extends Sensor {
  override def isTriggered: Boolean = false

  override def getLocation: String = null

  override def getSensorType: String = null

  override def getBatteryPercentage: Double = -1
}
