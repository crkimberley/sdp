import Math.pow

/**
  * @author Chris Kimberley
  */
object NumberPersonalities {
  val limit = 100

  def main(args: Array[String]): Unit = {
    for (number <- 1 to limit) println(number)
  }

  def isPrime(n: Int): Boolean = {
    if (n ==1) return false
    for (i <- 2 to n-1) {
      if (n % i == 0) return false
    }
    true
  }

  def isHappy(n: Int): Boolean = {
    var number = n
    while (number != 1) {
      var sumOfSquares = 0
      do {
        sumOfSquares += pow(number % 10, 2).toInt
        number /= 10
      } while (number != 0)
      number = sumOfSquares
      if (number == 4) return false
    }
    true
    }

  def isTriangular(n: Int): Boolean = {
    var number = n
    var i = 0
    while (number > 0) {
      i += 1
      number -= i
      if (number == 0) return true
    }
    false
  }

  def isSquare(n: Int): Boolean = {
    var number = n
    var i = -1
    while (number > 0) {
      i += 2
      number -= i
      if (number == 0) return true
    }
    false
  }

  def isSmug(n: Int): Boolean = {
    var i = 0
    var remainder = 0
    do {
      i += 1
      remainder = n - i * i
      if (isSquare(remainder)) return true
    } while (remainder > i * i)
    false
  }

  def isHonest(n: Int): Boolean = {
    var k = 0
    if (!isSquare(n)) {
      do {
        k += 1
        if (n / k == k) return false
      } while (n / k > k)
    }
    true
  }

  def isPronic(n: Int): Boolean = {
    var k = 0
      do {
        k += 1
        if (k * (k + 1) == n) return true
      } while (k * (k + 1) < n)
    false
  }

  def isDeficient(n: Int): Boolean = sumOfPositiveDivisorsOf(n) < n

  def isPerfect(n: Int): Boolean = sumOfPositiveDivisorsOf(n) == n

  def isAbundant(n: Int): Boolean = sumOfPositiveDivisorsOf(n) > n

  def sumOfPositiveDivisorsOf(n: Int): Int = {
    var k = 1
    var sumOfDivisors = 0
    do {
      sumOfDivisors += (if (n % k == 0) k else 0)
      k += 1
    } while (k <= n)
    sumOfDivisors - n
  }
}