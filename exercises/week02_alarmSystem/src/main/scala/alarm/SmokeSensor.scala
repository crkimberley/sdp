package alarm

import notification.{AlarmNotification, DefaultWarning}

class SmokeSensor(location: String, var warning: AlarmNotification =
DefaultWarning()) extends Sensor(location, warning) with HazardSensor {
  val alarmFrequencyPercentage = 80
  val batteryDrainBetweenPollsPercentage = 20
  // TEMPORARY DRAIN VALUE OF 0 FOR TESTING TRIGGERING
  //val batteryDrainBetweenPollsPercentage = 0
  var batteryPercentage = 100

  override def isTriggered: Boolean = {
    batteryPercentage = depletedBattery(batteryPercentage,
      batteryDrainBetweenPollsPercentage)
    isTriggered(batteryPercentage, alarmFrequencyPercentage)
  }

  override def getSensorType = "Smoke"

  override def getBatteryPercentage = batteryPercentage
}
