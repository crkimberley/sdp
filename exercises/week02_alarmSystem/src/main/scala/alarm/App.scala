package alarm

import java.io.IOException
import java.util.Scanner

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * @author Chris Kimberley
  */
object App {
  private val EXIT: String = "exit"
  private val POLL: String = "poll"

  @throws[IOException]
  def main(args: Array[String]) {
    var sensors: mutable.Buffer[Sensor] = new ArrayBuffer
    sensors.append(new FireSensor("kitchen"), new SmokeSensor("office"))
    val controlUnit: ControlUnit = new ControlUnit(sensors)
    val scanner: Scanner = new Scanner(System.in)
    var input: String = ""
    while (input != EXIT) {
      println("Type \"poll\" to poll all sensors once or \"exit\" to exit")
      input = scanner.nextLine
      if (input == POLL) {
        controlUnit.pollSensors
      }
    }
  }
}
