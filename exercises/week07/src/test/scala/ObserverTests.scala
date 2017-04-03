import observer._
import org.scalatest.FunSuite

import scala.collection.mutable.ListBuffer

/**
  * @author Chris Kimberley
  */
class ObserverTests extends FunSuite {

  val subject: Subject = new CommentaryObject(ListBuffer[Observer](), "Soccer Match [2014AUG24]")
  println(subject)

  val observer1: Observer = new SMSUsers(subject, "Adam Warner [New York]")
  observer1.subscribe
  println(subject)

  val observer2: Observer = new SMSUsers(subject, "Tim Ronney [London]")
  observer2.subscribe
  println(subject)

  val cObject: Commentary = (subject.asInstanceOf[Commentary])
  cObject.setDesc("Welcome to live Soccer match")
  cObject.setDesc("Current score 0-0")
  println(subject)

  observer2.unSubscribe
  println(subject)

  cObject.setDesc("It's a goal!!")
  cObject.setDesc("Current score 1-0")
  println(subject)

  val observer3: Observer = new SMSUsers(subject, "Marrie [Paris]")
  observer3.subscribe
  println(subject)

  cObject.setDesc("It's another goal!!")
  cObject.setDesc("Half-time score 2-0")
  println(subject)
}
