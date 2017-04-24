import org.scalatest.FunSuite
import strategy.CapTextFormatter

/**
  * @author Chris Kimberley
  */
class StrategyTests extends FunSuite {
  test("strategy") {
    val someText = "Hey what is that?"
    val textFormatter = CapTextFormatter()
    println(textFormatter.format(someText))

    textFormatter.strategy = (text: String) => text.toLowerCase
    println(textFormatter.format(someText))
  }
}