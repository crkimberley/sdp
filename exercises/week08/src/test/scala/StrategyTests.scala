import org.scalatest.FunSuite
import strategyAlt.CapTextFormatter

/**
  * @author Chris Kimberley
  */
class StrategyTests extends FunSuite {
  test("strategyAlt") {
    val someText = "Some Text To Be Formatted"
    val textFormatter = CapTextFormatter()
    println(textFormatter.format(someText))

    textFormatter.strategy = (text: String) => text.toLowerCase
    println(textFormatter.format(someText))
  }
}