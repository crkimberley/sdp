/**
  * @author Chris Kimberley
  */
package object strategyAlt {
  type Strategy = String => String

  val capTextFormatter: Strategy = _.toUpperCase
  val lowerTextFormatter: Strategy = _.toLowerCase
}