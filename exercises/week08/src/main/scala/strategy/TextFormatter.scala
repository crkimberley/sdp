package strategy

/**
  * @author Chris Kimberley
  */
case class CapTextFormatter() extends Context {
  var strategy = (text: String) => text.toUpperCase
}

case class LowerTextFormatter() extends Context {
  var strategy = (text: String) => text.toLowerCase
}