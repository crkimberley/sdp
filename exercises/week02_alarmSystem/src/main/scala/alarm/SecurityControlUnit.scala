package alarm

import java.util.Calendar

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * @author Chris Kimberley
  */
class SecurityControlUnit(sensors: ListBuffer[Sensor]) extends
  ControlUnit(sensors) {
  val securitySensorPollStartTime = 22
  val securitySensorPollEndTime = 6

  override def pollSensors {
    var currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    // currentTime loop for testing purposes
    //for (currentTime <- 0 to 23) {
      println(s"current hour is: $currentTime")
      if (currentTime >= securitySensorPollStartTime ||
        currentTime < securitySensorPollEndTime) super.pollSensors
    //}
  }
}