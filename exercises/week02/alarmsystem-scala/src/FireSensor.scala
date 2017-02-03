import scala.util.Random

class FireSensor extends Sensor {
  val alarmFrequencyPercentage = 5
  val r = new Random()
  val batteryDrainBetweenPollsPercentage = 10
  var batteryPercentage = 100
  var triggered: Boolean = false

  override def isTriggered: Boolean = {
    triggered =  if (batteryPercentage > 0) r.nextInt(100) < alarmFrequencyPercentage else false
    batteryDrain
    triggered
  }

  def batteryDrain: Unit = {
    batteryPercentage = if (batteryPercentage > batteryDrainBetweenPollsPercentage)
      batteryPercentage - batteryDrainBetweenPollsPercentage else 0
  }

  override def getLocation: String = null

  override def getSensorType: String = null

  override def getBatteryPercentage: Double = -1
}