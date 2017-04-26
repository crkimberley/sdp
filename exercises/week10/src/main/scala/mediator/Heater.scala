package mediator

class Heater extends Colleague {

  override def setMediator(mediator: MachineMediator): Unit = ???

  def on(temp: Int): Unit = ???

  def off(): Unit = ???
}