package mediator

class Sensor {

  def checkTemperature(temp: Int): Boolean = {
    println(s"Temperature reached $temp C")
    true
  }
}