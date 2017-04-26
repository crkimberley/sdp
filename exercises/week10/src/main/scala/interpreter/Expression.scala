package interpreter

trait Expression {
  def interpret(): Int
}