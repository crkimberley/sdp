/**
  * @author Chris Kimberley
  */
class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {

  def directorsAge = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director) = this.director == director

  def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease,
  imdbRating: Double = this.imdbRating, director: Director = this.director) = {
    new Film(name, yearOfRelease, imdbRating, director)}

  override def toString: String = {
    s"$name, $yearOfRelease, $imdbRating, ${director.name}"
  }

  override def equals(that: Any) = {
    that match {
      case x: Film => x.name == name && x.yearOfRelease == yearOfRelease &&
        x.imdbRating == imdbRating && x.director == director
      case _ => false
    }
  }
}