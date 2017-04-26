package mediator

object TestMediator extends App {
    val sensor = new Sensor()
    val soilRemoval = new SoilRemoval()
    val motor = new Motor()
    val machine = new Machine()
    val heater = new Heater()
    val valve = new Valve()
    val button = new Button()

    var mediator: MachineMediator =
      new CottonMediator(machine, heater, motor, sensor, soilRemoval, valve)

    button.setMediator(mediator)
    machine.setMediator(mediator)
    heater.setMediator(mediator)
    valve.setMediator(mediator)
    
    button.press()
    
    println(
      "******************************************************************************")
    
    mediator =
      new DenimMediator(machine, heater, motor, sensor, soilRemoval, valve)
    button.setMediator(mediator)
    machine.setMediator(mediator)
    heater.setMediator(mediator)
    valve.setMediator(mediator)
    button.press()
}