/**
  * Created by ckimbe02 on 28/02/2017.
  */
object AddOptions extends App {

  def addOptions1(opt1: Option[Int], opt2: Option[Int], opt3: Option[Int]): Option[Int] =
    opt1 flatMap {a =>
      opt2 flatMap { b =>
        opt3 map {  c =>
          a + b + c
        }
      }
    }

  println(addOptions1(Some(1), Some(2), Some(3)))
  println(addOptions1(None, Some(1), Some(10)))
  println(addOptions1(None, None, None))

  def addOptions2(opt1: Option[Int], opt2: Option[Int], opt3: Option[Int]): Option[Int] =
    for {
      a <- opt1
      b <- opt2
      c <- opt3
    } yield a + b + c

  println()
  println(addOptions2(Some(1), Some(2), Some(3)))
  println(addOptions2(None, Some(1), Some(10)))
  println(addOptions2(None, None, None))
}


object Divide extends App {
  def divide(numerator: Int, denominator: Int): Option[Double] = denominator match {
    case 0 => None
    case _ => Some(numerator/denominator.toDouble)
  }

  println(divide(1,0))
  println(divide(1,2))
  println(divide(0,3))

  def divide(numerator: Option[Int], denominator: Option[Int]): Option[Double] =
    for {
      a <- numerator
      b <- denominator
      c <- divide(a, b)
    } yield c

  println()
  println(divide(Some(1), Some(0)))
  println(divide(Some(1), Some(2)))
  println(divide(Some(0), Some(3)))
}