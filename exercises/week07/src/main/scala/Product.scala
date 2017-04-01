/**
  * Created by ckimbe02 on 21/02/2017.
  */
trait Product {
  def getName: String
}

case class ConcreteProductA() extends Product {
  def getName: String = "ProductA"
}

case class ConcreteProductB() extends Product {
  def getName: String = "ProductB"
}