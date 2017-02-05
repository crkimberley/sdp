import scala.util.Random

/**
  * @author Chris Kimberley
  */
trait HazardSensor extends Sensor {
  val r = new Random()

  def isTriggered(batteryPercentage: Int, alarmFrequency: Int) = {
    var randomInt = r.nextInt(100)
    if (batteryPercentage > 0) randomInt < alarmFrequency else false
  }

  def batteryDrainedPercentage(batteryPercentage: Int, batteryDrainBetweenPolls: Int) = {
    if (batteryPercentage > batteryDrainBetweenPolls)
      batteryPercentage - batteryDrainBetweenPolls else 0
  }

  def getBatteryPercentage: Double

  override def getSensorCategory = SensorCategory.HAZARD
}