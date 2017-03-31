/**
  * Created by ckimbe02 on 21/02/2017.
  */
trait Product {
  def displayProduct
}

case class ConcreteProduct() extends Product {
  def displayProduct = println("This is Concrete Product 1")
}

case class ConcreteProduct2() extends Product {
  def displayProduct = println("This is Concrete Product 2")
}