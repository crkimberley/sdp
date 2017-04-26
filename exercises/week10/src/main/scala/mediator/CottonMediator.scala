package mediator

class CottonMediator(private val machine: Machine,
                     private val heater: Heater,
                     private val motor: Motor,
                     private val sensor: Sensor,
                     private val soilRemoval: SoilRemoval,
                     private val valve: Valve)
    extends MachineMediator {

  println(".........................Setting up for COTTON program.........................")

  override def start() = machine.start

  override def wash(): Unit = {
    motor.startMotor()
    motor.rotateDrum(700)
    println("Adding detergent")
    soilRemoval.low()
    println("Adding softener")
  }

  override def open() = valve.open

  override def closed() = valve.closed

  override def on() = heater.on(40)

  override def off() = heater.off

  override def checkTemperature(temp: Int): Boolean =
    sensor.checkTemperature(temp)
}