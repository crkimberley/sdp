package visitor

object TestVisitorPattern extends App {
  println("Before visitor......... \n")

  var parentTag: HtmlTag = HtmlParentElement("<html>")

  parentTag.setStartTag("<html>")
  parentTag.setEndTag("</html>")

  var p1: HtmlTag = HtmlParentElement("<body>")

  p1.setStartTag("<body>")
  p1.setEndTag("</body>")
  parentTag.addChildTag(p1)

  var child1: HtmlTag = HtmlElement("<p>")

  child1.setStartTag("<p>")
  child1.setEndTag("</p>")
  child1.setTagBody("Testing html tag library")
  p1.addChildTag(child1)
  child1 = HtmlElement("<p>")
  child1.setStartTag("<p>")
  child1.setEndTag("</p>")
  child1.setTagBody("Paragraph 2")
  p1.addChildTag(child1)
  parentTag.generateHtml()

  println("\nAfter visitor....... \n")

  val cssClass: Visitor = CssClassVisitor()
  val style: Visitor = StyleVisitor()

  parentTag = HtmlParentElement("<html>")
  parentTag.setStartTag("<html>")
  parentTag.setEndTag("</html>")
  parentTag.accept(style)
  parentTag.accept(cssClass)

  p1 = HtmlParentElement("<body>")
  p1.setStartTag("<body>")
  p1.setEndTag("</body>")
  p1.accept(style)
  p1.accept(cssClass)
  parentTag.addChildTag(p1)

  child1 = HtmlElement("<p>")
  child1.setStartTag("<p>")
  child1.setEndTag("</p>")
  child1.setTagBody("Testing html tag library")
  child1.accept(style)
  child1.accept(cssClass)
  p1.addChildTag(child1)
  child1 = HtmlElement("<p>")
  child1.setStartTag("<p>")
  child1.setEndTag("</p>")
  child1.setTagBody("Paragraph 2")
  child1.accept(style)
  child1.accept(cssClass)
  p1.addChildTag(child1)
  parentTag.generateHtml()
}
