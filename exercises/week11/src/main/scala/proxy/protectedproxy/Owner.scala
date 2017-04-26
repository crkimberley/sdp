package proxy.protectedproxy

class Owner extends Staff {
  var isOwner: Boolean = true

  private var reportGenerator: ReportGeneratorProxy = ???

  override def setReportGenerator(
    reportGenerator: ReportGeneratorProxy
  ): Unit = ???

  def generateDailyReport(): String = ???
}
