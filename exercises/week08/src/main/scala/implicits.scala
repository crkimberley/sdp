import scala.math.Ordering._
/**
  * Created by ckimbe02 on 28/02/2017.
  */
object implicits extends App {

  implicit val ordering = Ordering.fromLessThan[Rational] { (x, y) =>
    (x.numerator.toDouble / x.denominator.toDouble) <
      (y.numerator.toDouble / y.denominator.toDouble)}

  final case class Rational(numerator: Int, denominator: Int)

  assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted == List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))

  println(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted)
}


