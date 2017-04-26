package mediator

trait MachineMediator {
  def start(): Unit
  def wash(): Unit
  def open(): Unit
  def closed(): Unit
  def on(): Unit
  def off(): Unit
  def checkTemperature(temp: Int): Boolean
}