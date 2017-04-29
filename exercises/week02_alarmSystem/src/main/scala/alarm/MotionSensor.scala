package alarm

/**
  * @author Chris Kimberley
  */
class MotionSensor(location: String) extends Sensor(location) with SecuritySensor {
  // Percentage in spec? Placeholder value: 8 percent
  val alarmFrequencyPercentage = 8

  override def getLocation = location

  override def getSensorType = "Motion"

  override def isTriggered = isTriggered(alarmFrequencyPercentage)
}