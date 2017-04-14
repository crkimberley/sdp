package singleton

// I think Scala objects are naturally lazy though

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