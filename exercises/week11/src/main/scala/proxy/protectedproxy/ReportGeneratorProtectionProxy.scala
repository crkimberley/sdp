package proxy.protectedproxy

class ReportGeneratorProtectionProxy(var staff: Staff)
  extends ReportGeneratorProxy {

  var reportGenerator: ReportGenerator = ???

  override def generateDailyReport(): String =
    if (staff.isOwner) {
      // YOUR CODE GOES HERE AND REPLACES ""
      ""
    } else {
      "Not Authorized to view report."
    }
}
