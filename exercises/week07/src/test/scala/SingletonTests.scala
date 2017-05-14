import org.scalatest.FunSuite
import singleton._

/**
  * @author Chris Kimberley
  */
class SingletonTests extends FunSuite {

  test("SingletonLazy uses Scala object to create singleton") {
    assert(SingletonLazy.toString == "This is a lazy singleton")
  }
}
