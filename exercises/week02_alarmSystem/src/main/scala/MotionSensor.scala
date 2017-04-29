/**
  * @author Chris Kimberley
  */
class MotionSensor extends Sensor with SecuritySensor {
  val location = ""
  // Percentage in spec? Placeholder value: 10 percent
  val alarmFrequencyPercentage = 10
  var triggered: Boolean = false

  override def getLocation = location

  override def getSensorType = "Motion"

  override def isTriggered = {
    isTriggered(alarmFrequencyPercentage)
  }
}