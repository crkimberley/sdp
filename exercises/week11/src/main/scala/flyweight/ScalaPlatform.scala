package flyweight

case class ScalaPlatform() extends Platform {

  println("ScalaPlatform object created")

  override def execute(code: Code): Unit =
    println("Compiling and executing Scala code.")
}
