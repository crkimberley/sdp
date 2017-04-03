import org.scalatest.FunSuite
import singleton._

/**
  * @author Chris Kimberley
  */
class SingletonTests extends FunSuite {
  test("SingletonEager uses Scala object to create singleton") {
    assert(SingletonLazy.toString == "This is a lazy singleton")
    assert(SingletonEager.getInstance.toString == "This is an eager singleton")
  }
}
