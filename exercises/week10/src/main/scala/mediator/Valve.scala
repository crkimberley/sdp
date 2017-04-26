package mediator

class Valve extends Colleague {

  override def setMediator(mediator: MachineMediator): Unit = ???

  def open(): Unit = ???

  def closed(): Unit = ???

}