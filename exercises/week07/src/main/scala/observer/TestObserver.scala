package observer

import scala.collection.mutable.ListBuffer

object TestObserver extends App {

  val subject: Subject = new CommentaryObject(ListBuffer[Observer](), "Soccer Match [2014AUG24]")

  val observer: Observer = new SMSUsers(subject, "Adam Warner [New York]")
  observer.subscribe
  println()

  val observer2: Observer = new SMSUsers(subject, "Tim Ronney [London]")
  observer2.subscribe

  val cObject: Commentary = (subject.asInstanceOf[Commentary])
  cObject.setDesc("Welcome to live Soccer match")
  cObject.setDesc("Current score 0-0")
  println()

  observer2.unSubscribe
  println()

  cObject.setDesc("It's a goal!!")
  cObject.setDesc("Current score 1-0")
  println()

  val observer3: Observer = new SMSUsers(subject, "Marrie [Paris]")
  observer3.subscribe
  println()

  cObject.setDesc("It's another goal!!")
  cObject.setDesc("Half-time score 2-0")
}

/*
MORE RECENT CODE FROM KEITH'S REPO - DOESN'T MATCH UP WITH OTHER NAMES

val obj: CommentaryObjectObservable = new CommentaryObjectObservable("Soccer Match [2014AUG24]")
val observer: SMSUsersObserver = new SMSUsersObserver(obj, "Adam Warner [New York]")
val observer2: SMSUsersObserver = new SMSUsersObserver(obj, "Tim Ronney [London]")
observer.subscribe
observer2.subscribe
println("-"*40)
obj.setDesc("Welcome to live Soccer match")
obj.setDesc("Current score 0-0")
observer.unSubscribe
obj.setDesc("It's a goal!!")
obj.setDesc("Current score 1-0")
*/