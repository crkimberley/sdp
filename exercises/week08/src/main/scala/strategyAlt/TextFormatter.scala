package strategyAlt

/**
  * @author Chris Kimberley
  */
case class CapTextFormatter() extends Formatter {
  var strategy = (text: String) => text.toUpperCase
}

case class LowerTextFormatter() extends Formatter {
  var strategy = (text: String) => text.toLowerCase
}