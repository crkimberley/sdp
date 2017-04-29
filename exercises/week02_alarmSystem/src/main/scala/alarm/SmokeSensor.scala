package alarm

class SmokeSensor(location: String) extends Sensor(location) with HazardSensor {
  val alarmFrequencyPercentage = 10
  val batteryDrainBetweenPollsPercentage = 20
  // TEMPORARY DRAIN VALUE OF 0 FOR TESTING TRIGGERING
  //val batteryDrainBetweenPollsPercentage = 0
  var batteryPercentage = 100

  override def isTriggered = {
    batteryPercentage = depletedBattery(batteryPercentage,
      batteryDrainBetweenPollsPercentage)
    isTriggered(batteryPercentage, alarmFrequencyPercentage)
  }

  override def getSensorType = "Smoke"

  override def getBatteryPercentage = batteryPercentage
}
