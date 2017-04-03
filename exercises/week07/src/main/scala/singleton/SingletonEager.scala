package singleton

/**
  * @author Chris Kimberley
  */
class SingletonEager private {
  override def toString: String = "This is an eager singleton"
}

object SingletonEager {
  val singletonEager = new SingletonEager
  def getInstance = singletonEager
}