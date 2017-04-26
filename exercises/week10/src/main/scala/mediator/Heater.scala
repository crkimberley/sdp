package mediator

class Heater extends Colleague {

  private var mediator: MachineMediator = _

  override def setMediator(mediator: MachineMediator): Unit =
    this.mediator = mediator

  def on(temp: Int): Unit = {
    println(s"Temperature is set to $temp")
    println("Heater is on...")
    if (mediator.checkTemperature(temp)) mediator.off()
    else println("Still heating up...")
  }

  def off(): Unit = {
    println("Heater is off...")
    mediator.wash()
  }
}