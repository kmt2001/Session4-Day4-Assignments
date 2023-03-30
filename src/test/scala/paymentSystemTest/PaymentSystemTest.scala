package paymentSystemTest

import org.scalatest.funsuite.AnyFunSuite
import paymentSystem._

class PaymentSystemTest extends AnyFunSuite {
  test("initial state has no payment methods") {
    assert(PaymentSystem.initialState.paymentMethods.isEmpty)
  }

  test("can add payment method to state") {
    val state = PaymentSystem.initialState
    val paymentMethod = CreditCard("1234567890123456", "12/23")
    val newState = PaymentSystem.addPaymentMethod(paymentMethod)(state)
    assert(newState.paymentMethods.contains(paymentMethod))
  }

  test("can process payment with credit card") {
    val paymentMethod = CreditCard("1234567890123456", "12/23")
    val amount = MoneyAmount(100.0)
    assert(PaymentSystem.processPayment(paymentMethod, amount).isRight)
  }

  test("can process payment with PayPal") {
    val paymentMethod = PayPal("test@example.com")
    val amount = MoneyAmount(100.0)
    assert(PaymentSystem.processPayment(paymentMethod, amount).isRight)
  }

  test("can process payment with bank transfer") {
    val paymentMethod = BankTransfer("1234567890")
    val amount = MoneyAmount(100.0)
    assert(PaymentSystem.processPayment(paymentMethod, amount).isRight)
  }
  test("cannot process payment with negative amount") {
    val paymentMethod = CreditCard("1234567890123456", "12/23")
    val amount = MoneyAmount(-100.0)
    assert(PaymentSystem.processPayment(paymentMethod, amount).isLeft)
  }

  test("can get all payment methods") {
    val state = PaymentSystem.initialState.copy(paymentMethods = Vector(
      CreditCard("1234567890123456", "12/23"),
      PayPal("test@example.com"),
      BankTransfer("1234567890")
    ))
    assert(PaymentSystem.getPaymentMethods(state).size == 3)
  }

  test("can get all credit cards") {
    val state = PaymentSystem.initialState.copy(paymentMethods = Vector(
      CreditCard("1234567890123456", "12/23"),
      PayPal("test@example.com"),
      CreditCard("9876543210987654", "12/24")
    ))
    assert(PaymentSystem.getCreditCards(state).size == 2)
  }

  test("can get total number of bank transfers") {
    val state = PaymentSystem.initialState.copy(paymentMethods = Vector(
      CreditCard("1234567890123456", "12/23"),
      BankTransfer("1234567890"),
      BankTransfer("0987654321")
    ))
    assert(PaymentSystem.getTotalBankTransfers(state) == 2)
  }

  test("can process payment with validation when validation passes") {
    val paymentMethod = CreditCard("1234567890123456", "12/23")
    val amount = MoneyAmount(100.0)
    val validate: Double => Boolean = value => value < 200
    assert(PaymentSystem.processPaymentWithValidation(paymentMethod, amount, validate).isRight)
  }
}