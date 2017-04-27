package state

trait RoboticState {
  def walk(): Unit
  def cook(): Unit
  def off(): Unit
}
