package prototype

class User(var userName: String,
           var level: String,
           var accessControl: AccessControl) {

  override def toString() = s"Name: $userName, Level: $level, " +
    s"Access Control Level: ${accessControl.controlLevel}, Access: ${accessControl.access}"
}