/**
  * @author Chris Kimberley
  */
/*class Director(firstName: String, lastName: String, val yearOfBirth: Int) extends
  Person(firstName: String, lastName: String) {

  def name = s"$firstName $lastName"
}*/
case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
  def name = s"$firstName $lastName"
}

object Director {

  /*def apply(firstName: String, lastName: String, yearOfBirth: Int) = {
    new Director(firstName, lastName, yearOfBirth)
  }*/

  def older(director1: Director, director2: Director) = {
    if (director1.yearOfBirth < director2.yearOfBirth) director1 else director2
  }
}