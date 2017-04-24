package abstractfactory

trait XMLParser {
  def parse: String
}

case class NYCErrorXMLParser() extends XMLParser {
  override def parse = {
    println("NYC parsing error XML...")
    "NYC Error XML Message"
  }
}

case class NYCFeedbackXMLParser() extends XMLParser {
  override def parse = {
    println("NYC parsing feedback XML...")
    "NYC Feedback XML Message"
  }
}

case class NYCOrderXMLParser() extends XMLParser {
  override def parse = {
    println("NYC parsing order XML...")
    "NYC Order XML Message"
  }
}

case class NYCResponseXMLParser() extends XMLParser {
  override def parse = {
    println("NYC parsing response XML...")
    "NYC Response XML Message"
  }
}

case class LondonErrorXMLParser() extends XMLParser {
  override def parse = {
    println("London parsing error XML...")
    "London Error XML Message"
  }
}

case class LondonFeedbackXMLParser() extends XMLParser {
  override def parse = {
    println("London parsing feedback XML...")
    "London Feedback XML Message"
  }
}

case class LondonOrderXMLParser() extends XMLParser {
  override def parse = {
    println("London parsing order XML...")
    "London Order XML Message"
  }
}

case class LondonResponseXMLParser() extends XMLParser {
  override def parse = {
    println("London parsing response XML...")
    "London Response XML Message"
  }
}
