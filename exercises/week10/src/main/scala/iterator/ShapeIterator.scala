package iterator

import java.util.Iterator

class ShapeIterator(private var shapes: Array[Shape]) extends Iterator[Shape] {

  private var index = 0

  override def hasNext(): Boolean = index < shapes.length

  override def next(): Shape = {
    if (!hasNext()) throw new NoSuchElementException
    index += 1
    shapes(index - 1)
  }

  override def remove(): Unit = shapes =
    shapes.take(index) ++ shapes.drop(index + 1)
}