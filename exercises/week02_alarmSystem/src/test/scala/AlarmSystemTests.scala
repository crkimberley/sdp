import alarm._
import notification.{CallFireDepartment, CallOwnersPhone}
import org.scalatest.FunSuite

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
/**
  * @author Chris Kimberley
  */
class AlarmSystemTests extends FunSuite {

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
    println(s"\nMotion trigger count = $triggerCount\n")
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

  test("ControlUnit") {
    println("\nControlUnit - pollSensors test\n")
    var sensors = new ListBuffer[Sensor]
    sensors.append(new FireSensor("kitchen", CallFireDepartment()),
      new SmokeSensor("office"),
      new FireSensor("lab", CallFireDepartment()),
      new SmokeSensor("store"))
    val controlUnit = new ControlUnit(sensors)
    for (i <- 1 to 10) controlUnit.pollSensors
  }

  test("SecurityControlUnit") {
    println("\nSecurityControlUnit - pollSensors test\n")
    var sensors = new ListBuffer[Sensor]
    sensors.append(new MotionSensor("kitchen", CallOwnersPhone()),
      new MotionSensor("office", CallOwnersPhone()),
      new MotionSensor("reception"))
    val controlUnit = new SecurityControlUnit(sensors)
    for (i <- 1 to 2) controlUnit.pollSensors
  }
}