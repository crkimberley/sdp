package prototype

object TestPrototypePattern extends App {
    var userAccessControl: AccessControl =
      AccessControlProvider.getAccessControlObject("USER")
    var user = new User("User A", "USER Level", userAccessControl)
    println("************************************")
    println(user)
    
    userAccessControl = AccessControlProvider.getAccessControlObject("USER")
    user = new User("User B", "USER Level", userAccessControl)

    println("Changing access control of: " + user.userName)
    
    user.accessControl.access = "READ REPORTS"
    println(user)
    println("************************************")
    
    val managerAccessControl: AccessControl =
      AccessControlProvider.getAccessControlObject("MANAGER")
    user = new User("User C", "MANAGER Level", managerAccessControl)
    println(user)
}

