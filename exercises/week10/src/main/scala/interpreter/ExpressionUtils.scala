package interpreter

object ExpressionUtils {

  private val operators = Vector("+", "-", "*", "/")

  def isOperator(s: String): Boolean = operators.contains(s)

  def getOperator(s: String, left: Expression, right: Expression): Expression =
  s match {
    case "+" => new Add(left, right)
    case "-" => new Subtract(left, right)
    case "*" => new Product(left, right)
    case "/" => new Divide(left, right)
  }
}