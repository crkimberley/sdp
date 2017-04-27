package template

abstract class ConnectionTemplate {

  def run(): Unit = {
    setDBDriver()
    setCredentials()
    connect()
    prepareStatement()
    setData()
    insert()
    close()
    destroy()
  }

  def setDBDriver(): Unit

  def setCredentials(): Unit

  def connect(): Unit = {
    println("Setting connection...")
  }

  def prepareStatement(): Unit = {
    println("Preparing insert statement...")
  }

  def setData(): Unit

  def insert(): Unit = {
    println("Inserting data...")
  }

  def close(): Unit = {
    println("Closing connections...")
  }

  def destroy(): Unit = {
    println("Destroying connection objects...")
  }
}
