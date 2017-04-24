package abstractfactory

object ParserFactoryProducer {
  def getFactory(s: String) = s match {
    case "NYCFactory" => NYCFactory()
    case "LondonFactory" => LondonFactory()
  }
}