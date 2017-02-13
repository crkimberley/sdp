import org.scalatest.FunSuite

/**
  * @author Chris Kimberley
  */
class ClassesTestSuite extends FunSuite {
  // Counter & Adder classes
  test("Value passed in via constructor is accessed through getter") {
    assert(Counter(13).count == 13)
  }

  test("inc method increments counter and returns a new Counter") {
    assert(Counter(19).inc().count == 20)
  }

  test("dec method decrements counter and returns a new Counter") {
    assert(Counter(29).dec().count == 28)
  }

  test("Sequence of inc & dec calls returns new Counter with correct count") {
    assert(Counter(10).inc().dec().inc().inc().count == 12)
  }

  test("Default value of 0 is returned for count") {
    assert(Counter().count == 0)
  }

  test("Count value passed in is correctly returned") {
    assert(Counter(17).count == 17)
  }

  test("adjust method returns Counter with passed in Adder applied to count") {
    val countValue = 6
    val adderAmount = 7
    val counter = Counter(countValue)
    val adder = new Adder(adderAmount)
    assert(counter.adjust(adder).count == countValue + adderAmount)
  }

  // Person class
  test("apply method splits supplied name & constructs new Person") {
    val person = Person("Britney Spears")
    assert(person.firstName == "Britney")
    assert(person.lastName == "Spears")
  }

  // Person class turned into a case class
  test("apply method of implicit object called when 2 arguments are supplied") {
    assert(Person("Taylor", "Swift").lastName == "Swift")
  }

  test("Empty string given as lastName when only 1 name supplied") {
    assert(Person("Katy").lastName == "")
  }

  // Film & Director classes
  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)
  val someGuy = new Director("Just", "Some Guy", 1990)

  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)

  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)

  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

  test("Director yearOfBirth returns correct value") {
    assert(eastwood.yearOfBirth == 1930)
  }

  test("Film director name returns correct value") {
    assert(dieHard.director.name == "John McTiernan")
  }

  test("Film isDirectedBy returns correct value") {
    assert(!invictus.isDirectedBy(nolan))
  }

  test("copy method creates copy with updated values") {
    assert(highPlainsDrifter.copy(name = "L’homme des hautes plaines") ==
      new Film("L’homme des hautes plaines", 1973, 7.7, eastwood))
    assert(thomasCrownAffair.copy(yearOfRelease = 1968, director = new Director
    ("Norman", "Jewison", 1926)) ==
      new Film("The Thomas Crown Affair", 1968, 6.8, new Director
      ("Norman", "Jewison", 1926)))
  }

  test("repeated copy method returns identical copy of film") {
    assert(inception.copy().copy().copy().toString == inception.toString)
  }

  // Director companion object methods
    test("apply method returns a new Director") {
    assert(Director("Bill", "Smith", 1999) == new Director("Bill", "Smith", 1999))
  }

  test("older method returns the older director") {
    assert(Director.older(eastwood, nolan) == eastwood)
    assert(Director.older(someGuy, mcTiernan) == mcTiernan)
  }

  // Film companion object methods
  test("apply method returns a new Film") {
    assert(Film("Toadstool City", 2007, 9.5, someGuy) ==
      new Film("Toadstool City", 2007, 9.5, someGuy))
  }

  test("highestRating method returns higher rated Film") {
    assert(Film.highestRating(predator, dieHard) == dieHard)
    assert(Film.highestRating(huntForRedOctober, thomasCrownAffair) == huntForRedOctober)
  }

  test("oldestDirectorAtTheTime returns older director") {
    assert(Film.oldestDirectorAtTheTime(highPlainsDrifter, memento) == eastwood)
    assert(Film.oldestDirectorAtTheTime(predator, inception) == nolan)
  }
}