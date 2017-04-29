package alarm

import scala.util.Random

/**
  * @author Chris Kimberley
  */
trait SecuritySensor extends Sensor {
  val r = new Random()

  def isTriggered(alarmFrequency: Int) = r.nextInt(100) < alarmFrequency

  override def getSensorCategory = "SECURITY"
}
