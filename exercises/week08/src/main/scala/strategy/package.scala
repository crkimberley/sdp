/**
  * @author Chris Kimberley
  */
package object strategy {
  type FormatStrategy = String => String

  trait Context {
    private[strategy] var strategy: FormatStrategy
    def format(text: String): String = strategy(text)
  }
}