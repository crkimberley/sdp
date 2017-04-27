package visitor

case class StyleVisitor() extends Visitor {
  override def visit(element: HtmlElement): Unit =
    element.setStartTag(element.getStartTag().
      replace(">", " style=’width:58px;’>"))

  override def visit(parentElement: HtmlParentElement): Unit =
    parentElement.setStartTag(parentElement.getStartTag().
      replace(">", " style=’width:58px;’>"))
}
