/**
  * @author Chris Kimberley
  */
class Director(firstName: String, lastName: String, val yearOfBirth: Int) extends
  Person(firstName: String, lastName: String) {

  def name = s"$firstName $lastName"
}
