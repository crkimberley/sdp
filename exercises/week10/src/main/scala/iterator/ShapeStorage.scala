package iterator

class ShapeStorage {

  var shapes = new Array[Shape](5)

  private var index: Int = 0

  def addShape(name: String): Unit = {
    shapes(index) = new Shape(index, name)
    index += 1
  }

  def getShapes = shapes
}