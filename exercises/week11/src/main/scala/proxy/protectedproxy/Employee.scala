package proxy.protectedproxy

class Employee extends Staff {
  private var reportGenerator: ReportGeneratorProxy = ???

  override def setReportGenerator(
    reportGenerator: ReportGeneratorProxy
  ): Unit = ???

  override def isOwner(): Boolean = false

  def generateDailyReport(): String = ???
}
