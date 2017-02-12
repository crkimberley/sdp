/**
  * @author Chris Kimberley
  */
/*
class Person(val firstName: String, val lastName: String) {}

object Person {
  def apply(name: String) = {
    val names = name.split(" ")
    new Person(names(0), names(1))
  }
}
*/

// Ex.2(b) What happens when we define a companion object for a case class?
// The case class creates a singleton object of the same name
// In this the explicit companion object's apply method is called if a single
// argument is supplied to the contructor and the implicit object's apply method
// is called two arguments (Strings) are supplied

case class Person(firstName: String, lastName: String) {}

object Person {
  def apply(name: String) = {
    val names = name.split(" ")
    new Person(names(0), if (names.length > 1) names(1) else "")
  }
}