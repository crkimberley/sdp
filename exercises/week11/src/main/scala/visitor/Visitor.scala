package visitor

trait Visitor {
  def visit(element: HtmlElement): Unit
  def visit(parentElement: HtmlParentElement): Unit
}