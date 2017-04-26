package proxy.virtualproxy

import scala.collection.mutable.ListBuffer

class ContactListProxyImpl extends ContactList {

  private var contactList: ContactList = ???

  override def employeeList: ListBuffer[Employee] = ???

}
