package visitor

trait Element {
  def accept(visitor: Visitor): Unit
}