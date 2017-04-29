import java.util.Calendar

import scala.collection.mutable

/**
  * @author Chris Kimberley
  */
class SecurityControlUnit(sensors: mutable.Buffer[Sensor]) extends ControlUnit(sensors) {
  val securitySensorPollStartTime = 22
  val securitySensorPollEndTime = 6

  override def pollSensors {
    var currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    if (currentTime >= securitySensorPollStartTime || currentTime < securitySensorPollEndTime) super.pollSensors
  }
}