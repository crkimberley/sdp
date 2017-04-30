package alarm

import notification.{AlarmNotification, DefaultWarning}

/**
  * @author Chris Kimberley
  */
class MotionSensor(location: String, var warning: AlarmNotification =
DefaultWarning()) extends Sensor(location, warning) with SecuritySensor {
  // Percentage in spec? Placeholder value: 8 percent
  val alarmFrequencyPercentage = 8

  override def getLocation = location

  override def getSensorType = "Motion"

  override def isTriggered: Boolean = isTriggered(alarmFrequencyPercentage)
}