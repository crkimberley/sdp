package decoupled

object HelloWorldDecoupled extends App {
  val mr: StandardOutMessageRenderer = new StandardOutMessageRenderer
  val mp: HelloWorldMessageProvider = new HelloWorldMessageProvider
  mr.setMessageProvider(mp)
  mr.render
}
