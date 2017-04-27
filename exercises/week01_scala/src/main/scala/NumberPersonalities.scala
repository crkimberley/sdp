/**
  * @author Chris Kimberley
  */
object NumberPersonalities {
  val limit = 100

  def main(args: Array[String]): Unit = {
    for (number <- 1 to limit) println(number)
  }

}