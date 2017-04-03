package adapter

/**
  * @author Chris Kimberley
  */
class XpayToPayDAdapter(val xpay: Xpay) extends PayD {
  override def getCustCardNo = xpay.getCreditCardNo

  override def setCustCardNo(custCardNo: String) =
    xpay.setCreditCardNo(custCardNo)

  override def getCardOwnerName = xpay.getCustomerName

  override def setCardOwnerName(cardOwnerName: String) =
    xpay.setCustomerName(cardOwnerName)

  override def getCardExpMonthDate = xpay.getCardExpMonth + "/" +
    xpay.getCardExpYear

  override def setCardExpMonthDate(cardExpMonthDate: String) {
    xpay.setCardExpMonth(cardExpMonthDate.take(2))
    xpay.setCardExpYear(cardExpMonthDate.drop(3))
  }

  override def getCVVNo = xpay.getCardCVVNo.toInt

  override def setCVVNo(cVVNo: Integer) = xpay.setCardCVVNo(cVVNo.toShort)

  override def getTotalAmount = xpay.getAmount

  override def setTotalAmount(totalAmount: Double) = xpay.setAmount(totalAmount)
}