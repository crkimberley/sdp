/**
  * Created by ckimbe02 on 21/02/2017.
  */
trait Creator {
  def anOperation: Product = factoryMethod

  def factoryMethod: Product

  /*def makeProduct(productType: String): Product = productType match {
    case "cp" => new ConcreteProduct
    case  _ => null
  }*/
}
