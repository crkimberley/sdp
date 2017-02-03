package di

trait MessageRenderer {
  def render

  def setMessageProvider(provider: MessageProvider)

  def getMessageProvider: MessageProvider
}