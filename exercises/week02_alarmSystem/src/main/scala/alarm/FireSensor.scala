package alarm

class FireSensor(location: String) extends Sensor(location) with HazardSensor {
  val alarmFrequencyPercentage = 5
  val batteryDrainBetweenPollsPercentage = 10
  // TEMPORARY DRAIN VALUE OF 0 FOR TESTING TRIGGERING
  //val batteryDrainBetweenPollsPercentage = 0
  var batteryPercentage = 100

  override def isTriggered = {
    batteryPercentage = depletedBattery(batteryPercentage,
      batteryDrainBetweenPollsPercentage)
    isTriggered(batteryPercentage, alarmFrequencyPercentage)
  }

  override def getSensorType = "Fire"

  override def getBatteryPercentage = batteryPercentage
}