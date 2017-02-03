package di

class StandardOutMessageRenderer extends MessageRenderer {
  private var messageProvider: MessageProvider = null

  override def render {
    if (messageProvider == null) {
      throw new RuntimeException("You must set the property messageProvider of class:"
        + classOf[StandardOutMessageRenderer].getName)
    }
    println(messageProvider.getMessage)
  }

  override def getMessageProvider: MessageProvider = {
    messageProvider
  }

  override def setMessageProvider(provider: MessageProvider) {
    messageProvider = provider
  }
}