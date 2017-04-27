package proxy.virtualproxy

import scala.collection.mutable.ListBuffer

class ContactListProxyImpl extends ContactList {

  private var contactList: ContactList = _

  override def employeeList: ListBuffer[Employee] = {
    if (contactList == null) contactList = ContactListImpl()
    contactList.employeeList
  }
}
