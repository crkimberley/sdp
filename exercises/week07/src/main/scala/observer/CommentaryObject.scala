package observer

import scala.collection.mutable.ListBuffer

case class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String)
  extends Subject with Commentary {

  private var updateText = ""

  def subscribeObserver(observer: Observer) = subscribers += observer

  def unSubscribeObserver(observer: Observer) = subscribers -= observer

  def notifyObservers() = {
    for (sub <- subscribers)
      sub.update(subjectDetails + ": " + updateText)
  }

  def subjectDetails: String = "UPDATE from " + title

  def setDesc(desc: String) = {
    updateText = desc
    notifyObservers()
  }

  // For testing purposes
  override def toString: String = {
    var result = title + "\nCurrent update text: " + updateText + "\nSUBSCRIBERS: "
    subscribers.foreach(sub => result += sub + " ")
    "\n" + result + "\n"
  }
}