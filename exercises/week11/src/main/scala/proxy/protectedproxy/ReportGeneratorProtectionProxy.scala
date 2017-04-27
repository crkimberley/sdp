package proxy.protectedproxy

class ReportGeneratorProtectionProxy(var staff: Staff)
  extends ReportGeneratorProxy {

  var reportGenerator: ReportGenerator = _

  override def generateDailyReport(): String =
    if (staff.isOwner) {
      "********************Location X Daily Report********************\n" +
        " Location ID: 012\n Today's Date: Sun Sep 14 13:28:12 IST 2014\n" +
        " Total Pizza Sell: 112\n Total Sale: $2534\n Net Profit: $1985\n" +
        "***************************************************************"
    } else {
      "Not Authorized to view report."
    }
}
