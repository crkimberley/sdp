/**
  * @author Chris Kimberley
  */
/*
class Counter(val count: Int) {
  def inc(value: Int = 1) = new Counter(count + 1)
  def dec(value: Int = 1) = new Counter(count - 1)
}
*/

case class Counter(count: Int = 1) {
  def inc(value: Int = 1) = new Counter(count + 1)
  def dec(value: Int = 1) = new Counter(count - 1)
}
