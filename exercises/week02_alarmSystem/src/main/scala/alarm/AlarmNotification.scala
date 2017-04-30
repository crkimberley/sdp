package notification

/**
  * @author Chris Kimberley
  */
trait AlarmNotification {
  def notification(location: String)
}

case class CallFireDepartment() extends AlarmNotification {
  override def notification(location: String) = println(s"FIRE! Location: $location")
}

case class CallOwnersPhone() extends AlarmNotification {
  override def notification(location: String) = println(s"INTRUDER! Location: $location")
}

case class DefaultWarning() extends AlarmNotification {
  override def notification(location: String) = println(s"ALARM! Location: $location")
}