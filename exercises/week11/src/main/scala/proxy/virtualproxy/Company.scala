package proxy.virtualproxy

case class Company(
  var companyName: String,
  var companyAddress: String,
  var companyContactNo: String,
  var contactList: ContactList
) {
  println("Company object created...")
}
