package decoupled

class HelloWorldMessageProvider {
  private val message: String = "Hello World!"

  def getMessage: String = {
    return message
  }
}