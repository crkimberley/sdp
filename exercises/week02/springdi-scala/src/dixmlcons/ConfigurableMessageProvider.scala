package dixmlcons

class ConfigurableMessageProvider(message: String) extends MessageProvider {

  override def getMessage: String = message
}
