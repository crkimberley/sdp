import scala.util.Random

/**
  * @author Chris Kimberley
  */
trait HazardSensor {
  val r = new Random()

  def isTriggered(batteryPercentage: Int, alarmFrequency: Int) = {
    if (batteryPercentage > 0) r.nextInt(100) < alarmFrequency else false
  }

  def batteryDrainedPercentage(batteryPercentage: Int, batteryDrainBetweenPolls: Int) = {
    if (batteryPercentage > batteryDrainBetweenPolls)
      batteryPercentage - batteryDrainBetweenPolls else 0
  }
}
