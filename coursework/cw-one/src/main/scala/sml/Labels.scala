package sml

//An instance contains a list of Strings, called "labels",
//in the order in which they were added to the list.

case class Labels() {
  var labels: Seq[String] = Seq()

  override def toString(): String =
    labels.mkString(" : ")

  def add(l: String) = labels = labels :+ l

  def apply(k: Int) = labels(k)
}