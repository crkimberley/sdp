package interpreter

class Number(private val n: Int) extends Expression {
  override def interpret(): Int = n
}
