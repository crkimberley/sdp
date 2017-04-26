package proxy.virtualproxy

import scala.collection.mutable.ListBuffer

case class ContactListImpl() extends ContactList {
  override def employeeList: ListBuffer[Employee] = {
    val empList = ListBuffer[Employee]()
    empList += new Employee("Employee A", 2565.55, "SE")
    empList += new Employee("Employee B", 22574, "Manager")
    empList += new Employee("Employee C", 3256.77, "SSE")
    empList += new Employee("Employee D", 4875.54, "SSE")
    empList += new Employee("Employee E", 2847.01, "SE")
    empList
  }
}
