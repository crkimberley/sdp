class FireSensor extends Sensor with HazardSensor {
  val location = ""
  val alarmFrequencyPercentage = 5
  val batteryDrainBetweenPollsPercentage = 10
  var batteryPercentage = 100
  var triggered: Boolean = false

  override def isTriggered = {
    var triggered = isTriggered(batteryPercentage, alarmFrequencyPercentage)
    batteryPercentage = batteryDrainedPercentage(batteryPercentage, batteryDrainBetweenPollsPercentage)
    triggered
  }

  override def getLocation = location

  override def getSensorType = "Fire"

  override def getBatteryPercentage = batteryPercentage
}