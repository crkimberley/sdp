package template

object TestTemplatePattern extends App {
  println("For MYSQL....")
  var template: ConnectionTemplate = MySqLCSVCon()
  template.run()
  println("\nFor Oracle...")
  template = OracleTxtCon()
  template.run()
}
