/**
  * @author Chris Kimberley
  */
/*
class Counter(val count: Int) {
  def inc(value: Int = 1) = new Counter(count + 1)
  def dec(value: Int = 1) = new Counter(count - 1)
}
*/

case class Counter(count: Int = 0) {
  def inc(incValue: Int = 1) = Counter(count + incValue)
  def dec(decvalue: Int = 1) = Counter(count - decvalue)
  def adjust(adder: Adder) = Counter(adder add count)
}