package state

object TestStatePattern extends App {
  val robot = Robot()
  robot.walk()
  robot.cook()
  robot.walk()
  robot.off()
  robot.walk()
  robot.off()
  robot.cook()
}
