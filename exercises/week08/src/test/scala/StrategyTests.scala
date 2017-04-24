import org.scalatest.FunSuite
import strategyAlt.{Context, capTextFormatter, lowerTextFormatter}

/**
  * @author Chris Kimberley
  */
class StrategyTests extends FunSuite {
  test("strategyAlt") {
    val someText = "Some Text To Be Formatted"
    println(new Context(capTextFormatter).format(someText))
    println(new Context(lowerTextFormatter).format(someText))

    println

    val context = new Context(capTextFormatter)
    println(context.format(someText))
    context.formatter = lowerTextFormatter
    println(context.format(someText))
  }
}