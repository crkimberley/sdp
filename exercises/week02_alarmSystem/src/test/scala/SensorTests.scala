import alarm._
import org.scalatest.FunSuite
/**
  * @author Chris Kimberley
  */
class SensorTests extends FunSuite {

  ignore("FireSensors trigger approx 5% of time if drain temporarily set to 0") {
    val sensor = new FireSensor("kitchen")
    var triggerCount = 0.0
    for (i <- 1 to 100000) {
      if (sensor.isTriggered) triggerCount += 0.001
    }
    println(s"Fire trigger count = $triggerCount")
    assert(triggerCount > 4.5 && triggerCount < 5.5)
  }

  ignore("Smoke Sensors trigger approx 10% of time if drain temporarily set to 0") {
    val sensor = new SmokeSensor("office")
    var triggerCount = 0.0
    for (i <- 1 to 100000) {
      if (sensor.isTriggered) triggerCount += 0.001
    }
    println(s"Smoke trigger count = $triggerCount")
    assert(triggerCount > 9.5 && triggerCount < 10.5)
  }

  test("Motion Sensors trigger approx 8% of time") {
    val sensor = new MotionSensor("reception")
    var triggerCount = 0.0
    for (i <- 1 to 100000) {
      if (sensor.isTriggered) triggerCount += 0.001
    }
    println(s"Motion trigger count = $triggerCount")
    assert(triggerCount > 7.5 && triggerCount < 8.5)
  }

  test("FireSensor runs down after 10 polls") {
    val sensor = new FireSensor("kitchen")
    var pollCount = 0
    while(sensor.getBatteryPercentage > 0) {
      pollCount += 1
      sensor.isTriggered
    }
    assert(pollCount == 10)
  }

  test("SmokeSensor runs down after 5 polls") {
    val sensor = new SmokeSensor("office")
    var pollCount = 0
    while(sensor.getBatteryPercentage > 0) {
      pollCount += 1
      sensor.isTriggered
    }
    assert(pollCount == 5)
  }

}
