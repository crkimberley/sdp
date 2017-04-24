package facadepattern

trait ScheduleServer {
  def startBooting

  def readSystemConfigFile

  def init

  def initializeContext

  def initializeListeners

  def createSystemObjects

  def releaseProcesses

  def destory

  def destroySystemObjects

  def destoryListeners

  def destoryContext

  def shutdown
}