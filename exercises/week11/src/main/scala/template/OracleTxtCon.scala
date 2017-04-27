package template

case class OracleTxtCon() extends ConnectionTemplate {
  override def setDBDriver(): Unit = println("Setting Oracle DB drivers...")
  override def setCredentials(): Unit = println("Setting credentials for Oracle DB...")
  override def setData(): Unit = println("Setting up data from txt file....")
}
