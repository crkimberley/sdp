package mediator

class Button extends Colleague {

  private var mediator: MachineMediator = _

  override def setMediator(mediator: MachineMediator): Unit = {
    this.mediator = mediator
  }

  def press(): Unit = {
    println("Button pressed.")
    mediator.start()
  }

}