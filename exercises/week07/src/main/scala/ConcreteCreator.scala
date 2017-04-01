/**
  * Created by ckimbe02 on 21/02/2017.
  */

// object used instead of class, as suggested by Hunt in Scala Design Patterns...
object ConcreteCreator extends Creator {
  def create(productType: String): Product = productType match {
    case "A" => ConcreteProductA()
    case "B" => ConcreteProductB()
  }
}