package decoupledinterface

object HelloWorldDecoupledInterface extends App {
  val mr: MessageRenderer = new StandardOutMessageRenderer
  val mp: MessageProvider = new HelloWorldMessageProvider
  mr.setMessageProvider(mp)
  mr.render
}
