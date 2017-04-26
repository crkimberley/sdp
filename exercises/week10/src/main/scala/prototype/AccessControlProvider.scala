package prototype

import scala.collection.mutable

object AccessControlProvider {

  private var map = new mutable.HashMap[String, AccessControl]()

  println("Fetching data from external resources and creating access control objects...")

  map.put("USER", new AccessControl("USER", "DO_WORK"))

  map.put("ADMIN", new AccessControl("ADMIN", "ADD/REMOVE USERS"))

  map.put("MANAGER", new AccessControl("MANAGER", "GENERATE/READ REPORTS"))

  map.put("VP", new AccessControl("VP", "MODIFY REPORTS"))

  def getAccessControlObject(controlLevel: String): AccessControl =
    map.apply(controlLevel)
}