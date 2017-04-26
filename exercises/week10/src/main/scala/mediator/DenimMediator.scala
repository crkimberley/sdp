package mediator

class DenimMediator(private val machine: Machine,
                    private val heater: Heater,
                    private val motor: Motor,
                    private val sensor: Sensor,
                    private val soilRemoval: SoilRemoval,
                    private val valve: Valve)
    extends MachineMediator {

  println(".........................Setting up for DENIM program.........................")

  override def start() = machine.start

  override def wash() = {
    motor.startMotor()
    motor.rotateDrum(1400)
    println("Adding detergent")
    soilRemoval.medium()
    println("No softener is required")
  }

  override def open() = valve.open

  override def closed() = valve.closed

  override def on() = heater.on(30)

  override def off() = heater.off

  override def checkTemperature(temp: Int): Boolean =
    sensor.checkTemperature(temp)
}