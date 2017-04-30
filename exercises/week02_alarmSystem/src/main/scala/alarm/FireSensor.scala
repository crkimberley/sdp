package alarm

import notification.{AlarmNotification, CallFireDepartment, DefaultWarning}

class FireSensor(location: String, var warning: AlarmNotification =
DefaultWarning()) extends Sensor(location, warning) with HazardSensor {
  val alarmFrequencyPercentage = 50
  val batteryDrainBetweenPollsPercentage = 10
  // TEMPORARY DRAIN VALUE OF 0 FOR TESTING TRIGGERING
  //val batteryDrainBetweenPollsPercentage = 0
  var batteryPercentage = 100

  override def isTriggered: Boolean = {
    batteryPercentage = depletedBattery(batteryPercentage,
      batteryDrainBetweenPollsPercentage)
    isTriggered(batteryPercentage, alarmFrequencyPercentage)
  }

  override def getSensorType = "Fire"

  override def getBatteryPercentage = batteryPercentage
}