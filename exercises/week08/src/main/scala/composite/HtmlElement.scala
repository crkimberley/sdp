package composite

case class HtmlElement(s: String) extends HtmlTag(s) {
  var startTag = ""
  var endTag = ""
  var body = ""

  override def setStartTag(tag: String): Unit = startTag = tag

  override def setEndTag(tag: String): Unit = endTag = tag

  override def setTagBody(tagBody: String): Unit = body = tagBody

  override def generateHtml: Unit = println(startTag + body + endTag)
}
