package mediator

trait Colleague {
  def setMediator(mediator: MachineMediator): Unit
}