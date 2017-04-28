import org.scalatest.FunSuite
import NumberPersonalities._

/**
  * @author Chris Kimberley
  */
class NumberPersonalitiesTest extends FunSuite {
  val limit = 100

  println(s"Testing numbers up to $limit")

  test("Primes") {
    print("Primes:")
    for (i <- 1 to limit) {
      if (isPrime(i)) print(s" $i")
    }
    println()
  }

  test("Happy numbers") {
    print("Happy numbers:")
    for (i <- 1 to limit) {
      if (isHappy(i)) print(s" $i")
    }
    println()
  }

  test("Triangular numbers") {
    print("Triangulars numbers:")
    for (i <- 1 to limit) {
      if (isTriangular(i)) print(s" $i")
    }
    println()
  }

  test("Square numbers") {
    print("Square numbers:")
    for (i <- 1 to limit) {
      if (isSquare(i)) print(s" $i")
    }
    println()
  }

  test("Smug numbers") {
    print("Smug numbers:")
    for (i <- 1 to limit) {
      if (isSmug(i)) print(s" $i")
    }
    println()
  }

  test("Honest numbers") {
    print("Honest numbers:")
    for (i <- 1 to limit) {
      if (isHonest(i)) print(s" $i")
    }
    println()
  }

  test("Pronic numbers") {
    print("Pronic numbers:")
    for (i <- 1 to limit) {
      if (isPronic(i)) print(s" $i")
    }
    println()
  }

  test("Deficient numbers") {
    print("Deficient numbers:")
    for (i <- 1 to limit) {
      if (isDeficient(i)) print(s" $i")
    }
    println()
  }

  test("Perfect numbers") {
    print("Perfect numbers:")
    for (i <- 1 to limit) {
      if (isPerfect(i)) print(s" $i")
    }
    println()
  }

  test("Abundant numbers") {
    print("Abundant numbers:")
    for (i <- 1 to limit) {
      if (isAbundant(i)) print(s" $i")
    }
    println()
  }

  test("sumOfPositiveDivisorsOf") {
    println("sumOfPositiveDivisorsOf:")
    for (i <- 1 to limit) {
      println(s" $i => ${sumOfPositiveDivisorsOf(i)}")
    }
    println()
  }
}