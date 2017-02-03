class SmokeSensor extends Sensor with HazardSensor {
  val location = ""
  val alarmFrequencyPercentage = 10
  val batteryDrainBetweenPollsPercentage = 20
  var batteryPercentage = 100
  var triggered: Boolean = false

  override def isTriggered = {
    var triggered = isTriggered(batteryPercentage, alarmFrequencyPercentage)
    batteryPercentage = batteryDrainedPercentage(batteryPercentage, batteryDrainBetweenPollsPercentage)
    triggered
  }

  override def getLocation = location

  override def getSensorType = "Smoke"

  override def getBatteryPercentage = batteryPercentage
}
