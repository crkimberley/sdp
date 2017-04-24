package strategy

case class TextEditor(formatter: TextFormatter) {
  def publishText(s: String) = formatter.format(s)
}
