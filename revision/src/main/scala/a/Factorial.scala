package a

object Factorial extends App {
  val factorials = List(20, 18, 32, 28, 22, 42, 55, 48)

  for (num <- factorials) {
    println(s"factorial for $num is ${factor(num)}")
  }

  private def factor(num: Int): BigInt = {
    num match {
      case 0 => 1
      case n => n * factor(n - 1)
    }
  }
}
