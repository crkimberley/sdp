import org.scalatest.FunSuite

/**
  * @author Chris Kimberley
  */
class ClassesTestSuite extends FunSuite {
  test("Value passed in via constructor is accessed through getter") {
    assert(new Counter(13).count == 13)
  }

  test("inc method increments counter and returns a new Counter") {
    assert(new Counter(19).inc().count == 20)
  }

  test("dec method decrements counter and returns a new Counter") {
    assert(new Counter(29).dec().count == 28)
  }

  test("Sequence of inc & dec calls returns new Counter with correct count") {
    assert(new Counter(10).inc().dec().inc().inc().count == 12)
  }

  test("Default value of 0 is returned for count") {
    assert(new Counter().count == 0)
  }

  test("Count value passed in is correctly returned") {
    assert(new Counter(17).count == 17)
  }

  test("adjust method returns Counter with passed in Adder applied to count") {
    val countValue = 6
    val adderAmount = 7
    val counter = new Counter(countValue)
    val adder = new Adder(adderAmount)
    assert(counter.adjust(adder).count == countValue + adderAmount)
  }
}
