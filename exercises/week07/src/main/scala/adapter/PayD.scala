package adapter

trait PayD {
  def getCustCardNo: String

  def setCustCardNo(custCardNo: String)

  def getCardOwnerName: String

  def setCardOwnerName(cardOwnerName: String)

  def getCardExpMonthDate: String

  def setCardExpMonthDate(cardExpMonthDate: String)

  def getCVVNo: Integer

  def setCVVNo(cVVNo: Integer)

  def getTotalAmount: Double

  def setTotalAmount(totalAmount: Double)
}
