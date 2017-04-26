package proxy.remoteproxy

import java.rmi.Remote
import java.rmi.RemoteException

trait ReportGenerator extends Remote {
  def generateDailyReport(): String
}
