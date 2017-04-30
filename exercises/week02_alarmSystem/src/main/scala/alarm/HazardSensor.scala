package alarm

import scala.util.Random

/**
  * @author Chris Kimberley
  */
trait HazardSensor extends Sensor {
  val r = new Random()

  def isTriggered(batteryPercentage: Int, alarmFrequency: Int) =
    batteryPercentage > 0 && r.nextInt(100) < alarmFrequency

  def depletedBattery(batteryPercentage: Int,
                      batteryDrainBetweenPollsPercentage: Int) =
    Math.max(0, batteryPercentage - batteryDrainBetweenPollsPercentage)

  override def getSensorCategory = "HAZARD"

  def getBatteryPercentage: Double
}
