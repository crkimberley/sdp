package facadepattern

case class ScheduleServerFacade(scheduleServer: ScheduleServer) {
  def stopServer: Unit = {
    scheduleServer.releaseProcesses
    scheduleServer.destory
    scheduleServer.destroySystemObjects
    scheduleServer.destoryListeners
    scheduleServer.destoryContext
    scheduleServer.shutdown
  }

  def startServer = {
    scheduleServer.startBooting
    scheduleServer.readSystemConfigFile
    scheduleServer.init
    scheduleServer.initializeContext
    scheduleServer.initializeListeners
    scheduleServer.createSystemObjects
  }
}