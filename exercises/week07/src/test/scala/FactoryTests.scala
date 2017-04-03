import factoryMethod.ConcreteCreator
import org.scalatest.FunSuite

/**
  * @author Chris Kimberley
  */
class FactoryTests extends FunSuite {
  test("New ConcreteProduct creation using factory method in " +
    "factoryMethod.Creator/ConcreteCreator") {
    val product1 = ConcreteCreator.create("A")
    val product2 = ConcreteCreator.create("B")
    assert(product1.getName == "ProductA")
    assert(product2.getName == "ProductB")
  }
}