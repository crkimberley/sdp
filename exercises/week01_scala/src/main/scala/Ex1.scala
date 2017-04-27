/**
  * @author Chris Kimberley
  */
object Ex1 extends App {
  import scala.io.StdIn._
  import scala.math._

  val number = readLine("Please enter an integer: ").toInt

  println()

  println(if (number > 100) "That's a big number" else "That's a small number")

  println()

  var numberEntered = 1
  while(numberEntered != 0) {
    numberEntered = readLine("Enter a number: ").toInt
    println(s"You entered $numberEntered. The square of that is ${pow(numberEntered, 2)}")
  }
  println("You entered zero - I'll stop")

  println()

  for (i <- 1 to 25) println(s"$i • ${i * i} • ${i * i * i}")
}