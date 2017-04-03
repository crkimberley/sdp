package observer

case class SMSUsers(s: Subject, msg: String) extends Observer {
  def update(desc: String) = println(msg + " • " + desc)

  def subscribe() = s.subscribeObserver(this)

  def unSubscribe() = s.unSubscribeObserver(this)

  // For testing purposes
  override def toString = msg
}
