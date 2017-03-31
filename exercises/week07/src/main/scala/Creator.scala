/**
  * Created by ckimbe02 on 21/02/2017.
  */
trait Creator {
  def makeProduct(productType: String): Product = productType match {
    case "c" => new ConcreteProduct
    case  _ => new DefaultProduct
  }
}
