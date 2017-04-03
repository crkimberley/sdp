import adapter.{XpayImpl, XpayToPayDAdapter}
import org.scalatest.FunSuite

/**
  * @author Chris Kimberley
  */
class AdapterTests extends FunSuite {
  val xpay1 = new XpayImpl
  xpay1.setCreditCardNo("1234567890123456")
  xpay1.setCustomerName("Steve Gadd")
  xpay1.setCardExpMonth("05")
  xpay1.setCardExpYear("2018")
  xpay1.setCardCVVNo(101)
  xpay1.setAmount(1989.17)

  val xpay1Adapter = new XpayToPayDAdapter(xpay1)

  test("setCreditCardNo/getCustCardNo") {
    assert(xpay1Adapter.getCustCardNo == "1234567890123456")
  }

  test("setCustomerName/getCardOwnerName") {
    assert(xpay1Adapter.getCardOwnerName == "Steve Gadd")
  }

  test("setCardExpMonthAndYear/getCardExpMonthDate") {
    assert(xpay1Adapter.getCardExpMonthDate == "05/2018")
  }

  test("setCardCVVNo/getCVVNo") {
    assert(xpay1Adapter.getCVVNo == 101)
  }

  test("setAmount/getTotalAmount") {
    assert(xpay1Adapter.getTotalAmount == 1989.17)
  }

  val xpay2 = new XpayImpl
  val xpay2Adapter = new XpayToPayDAdapter(xpay2)

  xpay2Adapter.setCustCardNo("1111222233334444")
  xpay2Adapter.setCardOwnerName("Buddy Rich")
  xpay2Adapter.setCardExpMonthDate("07/2019")
  xpay2Adapter.setCVVNo(303)
  xpay2Adapter.setTotalAmount(1812.29)

  test("setCustCardNo/getCreditCardNo") {
    assert(xpay2.getCreditCardNo == "1111222233334444")
  }

  test("setCardOwnerName/getCustomerName") {
    assert(xpay2.getCustomerName == "Buddy Rich")
  }

  test("setCardExpMonthDate/getCardExpMonth") {
    assert(xpay2.getCardExpMonth == "07")
  }

  test("setCardExpMonthDate/getCardExpYear") {
    assert(xpay2.getCardExpYear == "2019")
  }

  test("setCVVNo/getCardCVVNo") {
    assert(xpay2.getCardCVVNo == 303)
  }

  test("setTotalAmount/getAmount") {
    assert(xpay2.getAmount == 1812.29)
  }
}