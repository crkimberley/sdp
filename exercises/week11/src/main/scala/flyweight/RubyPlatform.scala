package flyweight

/**
  * @author Chris Kimberley
  */
case class RubyPlatform() extends Platform {

  println("RubyPlatform object created")

  override def execute(code: Code): Unit =
    println("Compiling and executing Ruby code.")
}