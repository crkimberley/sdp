/**
  * @author Chris Kimberley
  */
package object strategyAlt {
  type Strategy = String => String

  trait Formatter {
    private[strategyAlt] var strategy: Strategy
    def format(text: String): String = strategy(text)
  }
}