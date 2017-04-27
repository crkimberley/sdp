package proxy.virtualproxy

case class Employee(
  var employeeName: String,
  var employeeSalary: Double,
  var employeeDesignation: String
) {

  override def toString(): String = s"EmployeeName: $employeeName, " +
    s"EmployeeDesignation: $employeeDesignation, Employee Salary: $employeeSalary"
}
