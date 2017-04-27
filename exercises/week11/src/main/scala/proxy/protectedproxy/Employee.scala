package proxy.protectedproxy

class Employee extends Staff {
  private var reportGenerator: ReportGeneratorProxy = _

  override def setReportGenerator(reportGenerator: ReportGeneratorProxy): Unit =
    this.reportGenerator = reportGenerator

  override def isOwner(): Boolean = false

  def generateDailyReport(): String = reportGenerator.generateDailyReport()
}
