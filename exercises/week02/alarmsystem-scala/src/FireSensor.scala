import scala.util.Random

class FireSensor(location: String) extends Sensor {
  val alarmFrequencyPercentage = 5
  val r = new Random()
  val batteryDrainBetweenPollsPercentage = 10
  var batteryPercentage = 100
  var triggered: Boolean = false


  override def isTriggered = {
    triggered =  if (batteryPercentage > 0) r.nextInt(100) < alarmFrequencyPercentage else false
    batteryDrain
    triggered
  }

  def batteryDrain {
    batteryPercentage = if (batteryPercentage > batteryDrainBetweenPollsPercentage)
      batteryPercentage - batteryDrainBetweenPollsPercentage else 0
  }

  override def getLocation = location

  override def getSensorType = "Fire"

  override def getBatteryPercentage = batteryPercentage
}