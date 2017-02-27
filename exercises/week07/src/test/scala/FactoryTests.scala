import org.scalatest.FunSuite

/**
  * @author Chris Kimberley
  */
class FactoryTests extends FunSuite {
  test("New ConcreteProduct creation using factory method in Creator") {
    val factory = new Creator
    val newProduct: Product = factory makeProduct "cp"
    newProduct.displayProduct
  }
}
