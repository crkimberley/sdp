package memento

case class Originator(
  var x: Double,
  var y: Double,
  var careTaker: CareTaker
) {

  private var lastUndoSavepoint: String = _

  createSavepoint("INITIAL")

  def createSavepoint(savepointName: String): Unit = {
    println(s"Saving state...$savepointName")
    careTaker.saveMemento(new Memento(x, y), savepointName)
    lastUndoSavepoint = savepointName
  }

  def undo(): Unit = setOriginatorState(lastUndoSavepoint)

  def undo(savepointName: String): Unit = setOriginatorState(savepointName)

  def undoAll(): Unit = {
    setOriginatorState("INITIAL")
    careTaker.clearSavepoints()
    println("Clearing all save points...")
  }

  private def setOriginatorState(savepointName: String): Unit = {
    println(s"Undo at...$savepointName")
    x = careTaker.getMemento(savepointName).x
    y = careTaker.getMemento(savepointName).y
  }
  override def toString(): String = "X: " + x + ", Y: " + y
}
