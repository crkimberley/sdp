package decoupledinterface

class HelloWorldMessageProvider extends MessageProvider {
  override def getMessage: String = {
    "Hello World!"
  }
}
