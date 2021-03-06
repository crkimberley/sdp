import scala.io.StdIn._
import scala.util.Random
import util.control.Breaks._

/**
  * @author Chris Kimberley
  */
object Hammurabi extends App {

  val randomNumberGenerator = new Random()

  def hammurabi = {
    var starved = 0 // how many people starved
    var immigrants = 5 // how many people came to the city
    var population = 100
    var harvest = 3000 // total bushels harvested
    var bushelsPerAcre = 3 // amount harvested for each acre planted
    var rats_ate = 200 // bushels destroyed by rats
    var bushelsInStorage = 2800
    var acresOwned = 1000
    var pricePerAcre = 19 // each acre costs this many bushels
    var plagueDeaths = 0

    printIntroductoryMessage

    for (year <- 1 to 10) {
      println("O great Hammurabi!")
      println("You are in year " + year + " of your ten year rule.")
      println("In the previous year " + starved +
        " people starved to death.")
      println("In the previous year " + immigrants +
        " people entered the kingdom.")
      println("The population is now " + population + ".")
      println("We harvested 3000 bushels at " + bushelsPerAcre +
        " bushels per acre.")
      println("Rats destroyed " + rats_ate + " bushels, leaving " +
        bushelsInStorage + " bushels in storage.")
      println("The city owns " + acresOwned + " acres of land.")
      println("Land is currently worth " + pricePerAcre +
        " bushels per acre.")
      println("There were " + plagueDeaths + " deaths from the plague.")
      println()

      var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
      acresOwned += acresToBuy
      bushelsInStorage -= acresToBuy * pricePerAcre

      if (acresToBuy == 0) {
        var acresToSell = askHowMuchLandToSell(acresOwned)
        acresOwned -= acresToSell
        bushelsInStorage += acresToSell * pricePerAcre
      }

      var grainForPeople = askHowMuchGrainToFeedPeople(bushelsInStorage)
      bushelsInStorage -= grainForPeople

      var acresToPlant =
        askHowMuchLandToPlant(acresOwned, bushelsInStorage, population)
      bushelsInStorage -= acresToPlant * 2

      if (plague) {
        plagueDeaths += (population / 2)
        population /= 2
      }

      var numberOfPeopleWhoCouldBeFed = grainForPeople / 20
      var peopleStarved = if (numberOfPeopleWhoCouldBeFed < population)
        population - numberOfPeopleWhoCouldBeFed
      else 0
      if (peopleStarved * 100 / population > 45) {
        println("TOO MANY PEOPLE STARVED - YOUR REIGN IS OVER!")
        break
      }
      starved += peopleStarved

      var immigrantsThisYear = immigrantsComing(peopleStarved, acresOwned,
        bushelsInStorage, population)
      immigrants += immigrantsThisYear
      population += immigrants

      var thisYearsHarvest = harvestThisYear(acresToPlant)
      harvest += thisYearsHarvest

      bushelsInStorage -= (percentageEatenByRats * bushelsInStorage / 100)

      pricePerAcre = landCost
    }

    println("Final Result")
    println(s"Number of people who starved = $starved")
    println(s"Number of acres = $acresOwned")
  }

  def printIntroductoryMessage = println(
    """
      |Congratulations, you are the newest ruler of ancient Samaria, elected
      |for a ten year term of office. Your duties are to dispense food, direct
      |farming, and buy and sell land as needed to support your people. Watch
      |out for rat infestations and the plague! Grain is the general currency,
      |measured in bushels. The following will help you in your decisions:
      |* Each person needs at least 20 bushels of grain per year to survive.
      |* Each person can farm at most 10 acres of land.
      |* It takes 2 bushels of grain to farm an acre of land.
      |* The market price for land fluctuates yearly.
      |Rule wisely and you will be showered with appreciation at the end of
      |your term. Rule poorly and you will be kicked out of office!
    """.stripMargin)

  def readInt(message: String): Int = {
    try {
      readLine(message).toInt
    } catch {
      case _: Throwable =>
        println("That's not an integer. Please enter an integer.")
        readInt(message)
    }
  }

  def askHowMuchLandToBuy(bushelsInStorage: Int, pricePerAcre: Int) = {
    var acresToBuy = readInt("How many acres will you buy? ")
    while (acresToBuy < 0 || acresToBuy * pricePerAcre > bushelsInStorage) {
      println(
        s"O Great Hammurabi, we have but $bushelsInStorage bushels of grain!")
      acresToBuy = readInt("How many acres will you buy? ")
    }
    acresToBuy
  }

  def askHowMuchLandToSell(acresOwned: Int) = {
    var acresToSell = readInt("How many acres would you like to sell? ")
    while (acresToSell < 0 || acresToSell > acresOwned) {
      println(s"O Great Hammurabi, we only own $acresOwned acres!")
      acresToSell = readInt("How many acres would you like to sell? ")
    }
    acresToSell
  }

  def askHowMuchGrainToFeedPeople(bushelsInStorage: Int) = {
    var grainForPeople = readInt("How much grain will you feed the people? ")
    while (grainForPeople < 0 || grainForPeople > bushelsInStorage) {
      println(
        s"O Great Hammurabi, we only have $bushelsInStorage bushels of grain!")
      grainForPeople = readInt("How much grain will you feed the people? ")
    }
    grainForPeople
  }

  def askHowMuchLandToPlant
  (acresOwned: Int, bushelsInStorage: Int, population: Int) = {
    var acresToPlant = readInt("How many acres will you plant with seed? ")
    while (acresToPlant < 0 || acresToPlant > acresOwned ||
      acresToPlant * 2 > bushelsInStorage || acresToPlant > population * 10) {
      println(s"O Great Hammurabi, we only own $acresOwned acres")
      println(s"and only have $bushelsInStorage bushels")
      println(s"and the population is only $population")
      acresToPlant = readInt("How many acres will you plant with seed? ")
    }
    acresToPlant
  }

  def plague = randomNumberGenerator.nextInt(100) < 15

  def immigrantsComing(peopleStarved: Int, acresOwned: Int,
                       bushelsInStorage: Int, population: Int) = {
    if (peopleStarved == 0)
      (20 * acresOwned + bushelsInStorage) / (100 * population) + 1
    else 0
  }

  def harvestThisYear(acresToPlant: Int) =
    acresToPlant * (randomNumberGenerator.nextInt(7) + 1)

  def percentageEatenByRats = {
    if (randomNumberGenerator.nextInt(100) < 40)
      (randomNumberGenerator.nextInt(2) + 1) * 10
    else 0
  }

  def landCost = 17 + randomNumberGenerator.nextInt(7)

  hammurabi
}
