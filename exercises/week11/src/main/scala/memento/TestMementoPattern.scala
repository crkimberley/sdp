package memento

object TestMementoPattern extends App {
  val careTaker: CareTaker = CareTaker()
  val originator: Originator = Originator(5, 10, careTaker)
  println("Default State: " + originator)

  originator.x = originator.y * 51
  println("State: " + originator)

  originator.createSavepoint("SAVE1")
  originator.y = originator.x / 22
  println("State: " + originator)

  originator.undo()
  println("State after undo: " + originator)

  originator.x = Math.pow(originator.x, 3)
  originator.createSavepoint("SAVE2")
  println("State: " + originator)

  originator.y = originator.x - 30
  originator.createSavepoint("SAVE3")
  println("State: " + originator)

  originator.y = originator.x / 22
  originator.createSavepoint("SAVE4")
  println("State: " + originator)

  originator.undo("SAVE2")
  println("Retrieving at: " + originator)
  originator.undoAll
  println("State after undo all: " + originator)
}
