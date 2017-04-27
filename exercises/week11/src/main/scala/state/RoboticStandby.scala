package state

case class RoboticStandby(r: Robot) extends RoboticState {
  def walk(): Unit = {
    r.state = r.roboticOn
    r.state.walk()
  }
  def cook(): Unit = {
    r.state = r.roboticOn
    r.state.cook()
  }
  def off(): Unit = {
    r.state = r.roboticOff
    r.state.off()
  }
}
