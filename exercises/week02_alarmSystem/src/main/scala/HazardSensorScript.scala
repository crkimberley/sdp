/**
  * @author Chris Kimberley
  */
object HazardSensorScript extends App {
  val fireSensor = new FireSensor
  val smokeSensor = new SmokeSensor
  println("location: " + fireSensor.getLocation + ", " + "type: " + fireSensor.getSensorType)
  for (i <- 1 to 20) println(i + " " + fireSensor.isTriggered + fireSensor.getBatteryPercentage)

  println("location: " + smokeSensor.getLocation + ", " + "type: " + smokeSensor.getSensorType)
  for (i <- 1 to 20) println(i + " " + smokeSensor.isTriggered + smokeSensor.getBatteryPercentage)
}
