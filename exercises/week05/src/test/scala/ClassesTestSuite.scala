import org.scalatest.FunSuite

/**
  * @author Chris Kimberley
  */
class ClassesTestSuite extends FunSuite {
  test("Value passed in via constructor is accessed through getter") {
    assert(new Counter(13).count == 13)
  }

  test("inc method increments counter and returns a new Counter") {
    assert(new Counter(19).inc.count == 20)
  }

  test("dec method decrements counter and returns a new Counter") {
    assert(new Counter(29).dec.count == 28)
  }

  test("Sequence of inc & dec calls returns new Counter with correct count") {
    assert(new Counter(10).inc.dec.inc.inc.count == 12)
  }
}
