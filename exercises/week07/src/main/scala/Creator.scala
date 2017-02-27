/**
  * Created by ckimbe02 on 21/02/2017.
  */
class Creator {
  def makeProduct(productType: String): Product = productType match {
    case "cp" => new ConcreteProduct
    case  _ => null
  }
}
