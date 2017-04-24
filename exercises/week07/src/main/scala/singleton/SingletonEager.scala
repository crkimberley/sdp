package singleton

// I think Scala objects are naturally lazy though

/**
  * @author Chris Kimberley
  */
class SingletonEager private() {
  private val instance = null
}

object SingletonEager {
  println("Object creation?")
  private val instance = new SingletonEager
  def getInstance = instance
}