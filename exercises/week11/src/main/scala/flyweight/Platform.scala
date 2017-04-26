package flyweight

trait Platform {
  def execute(code: Code): Unit
}
