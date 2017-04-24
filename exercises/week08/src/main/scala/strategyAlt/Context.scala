package strategyAlt

/**
  * @author Chris Kimberley
  */
class Context(var formatter: Strategy) {
  def format(text: String) = formatter(text)
}
