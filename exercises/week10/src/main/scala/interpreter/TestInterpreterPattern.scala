package interpreter

import java.util.Stack

object TestInterpreterPattern extends App {
    val tokenString: String = "7 3 - 2 1 + *"
    val stack: Stack[Expression] = new Stack[Expression]()
    val tokenArray: Array[String] = tokenString.split(" ")
    for (s <- tokenArray) {
      if (ExpressionUtils.isOperator(s)) {
        val rightExpression: Expression = stack.pop()
        val leftExpression: Expression = stack.pop()
        val operator: Expression =
          ExpressionUtils.getOperator(s, leftExpression, rightExpression)
        stack.push(new Number(operator.interpret()))
      } else {
        stack.push(new Number(java.lang.Integer.parseInt(s)))
      }
    }
    println("( " + tokenString + " ): " + stack.pop().interpret())
}
