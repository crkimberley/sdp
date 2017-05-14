package b

import scala.annotation.tailrec

object Factorial extends App {
  val factorials = List(20, 18, 32, 28, 22, 42, 55, 48)

  for (num <- factorials) {
    println(s"factorial for $num is ${factor(num)}")
  }

  private def factor(num: Int) = factorTail(num, 1)

  @tailrec private def factorTail(num: Int, acc: BigInt): BigInt = {
    (num, acc) match {
      case (0, a) => a
      case (n, a) => factorTail(n - 1, n * a)
    }
  }
}
