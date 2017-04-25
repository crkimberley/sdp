package composite

import scala.collection.mutable.ListBuffer

case class HtmlParentElement(s: String) extends HtmlTag(s) {
  var startTag = ""
  var endTag = ""
  var children = ListBuffer[HtmlTag]()

  override def setStartTag(tag: String): Unit = startTag = tag

  override def setEndTag(tag: String): Unit = endTag = tag

  override def addChildTag(htmlTag: HtmlTag): Unit =
    children += htmlTag

  override def removeChildTag(htmlTag: HtmlTag): Unit =
    children -= htmlTag

  override def getChildren: List[HtmlTag] = children.toList

  override def generateHtml: Unit = {
    println(startTag)
    children.foreach(child => child.generateHtml)
    println(endTag)
  }
}