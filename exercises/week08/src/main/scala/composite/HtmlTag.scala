package composite

abstract class HtmlTag(tagName: String) {

  def getTagName: String = tagName

  def setStartTag(tag: String)

  def setEndTag(tag: String)

  def setTagBody(tagBody: String): Unit = throw new UnsupportedOperationException

  def addChildTag(htmlTag: HtmlTag): Unit = throw new UnsupportedOperationException

  def removeChildTag(htmlTag: HtmlTag): Unit = throw new UnsupportedOperationException

  def getChildren: List[HtmlTag] = throw new UnsupportedOperationException

  def generateHtml
}