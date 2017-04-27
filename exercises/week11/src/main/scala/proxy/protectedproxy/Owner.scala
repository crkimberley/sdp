package proxy.protectedproxy

class Owner extends Staff {
  var isOwner: Boolean = true

  private var reportGenerator: ReportGeneratorProxy = _

  override def setReportGenerator(reportGenerator: ReportGeneratorProxy): Unit =
    this.reportGenerator = reportGenerator

  def generateDailyReport(): String = reportGenerator.generateDailyReport()
}
