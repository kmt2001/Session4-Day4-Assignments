package paymentSystem

import scala.util.Try

// Define the payment methods available
sealed trait PaymentMethod

final case class CreditCard(cardNumber: String, expiryDate: String) extends PaymentMethod
final case class PayPal(emailAddress: String) extends PaymentMethod
final case class BankTransfer(accountNumber: String) extends PaymentMethod

// Define a value object to represent the amount of money being paid
case class MoneyAmount(value: Double) {
  def isPositive: Boolean = value > 0
}

// Define the state of the payment system
case class PaymentSystemState(paymentMethods: Vector[PaymentMethod])

object PaymentSystem {

  // An initial state for the payment system
  val initialState: PaymentSystemState = PaymentSystemState(Vector.empty)

  // A function to add a payment method to the state
  def addPaymentMethod(paymentMethod: PaymentMethod): PaymentSystemState => PaymentSystemState =
    state => state.copy(paymentMethods = paymentMethod +: state.paymentMethods)

  // A function to process a payment using the given payment method and amount of money
  def processPayment(paymentMethod: PaymentMethod, amount: MoneyAmount): Either[String, Unit] =
    paymentMethod match {
      case CreditCard(_ , _) if amount.isPositive =>
        // Process payment using credit card
        Right(())
      case PayPal(_) if amount.isPositive =>
        // Process payment using PayPal
        Right(())
      case BankTransfer(_) if amount.isPositive =>
        // Process payment using bank transfer
        Right(())
      case _ =>
        // Payment method or amount is invalid
        Left("Invalid payment method or amount")
    }

  // A function to get a list of all payment methods
  val getPaymentMethods: PaymentSystemState => Vector[PaymentMethod] =
    state => state.paymentMethods

  // A function to get a list of all credit cards that have been added
  val getCreditCards: PaymentSystemState => Vector[CreditCard] =
    state => state.paymentMethods.collect { case c: CreditCard => c }

  // A function to get the total number of bank transfers that have been added
  val getTotalBankTransfers: PaymentSystemState => Double =
    state => state.paymentMethods.collect { case BankTransfer(_) => 1.0 }.sum

  // A function to process a payment with validation, where the validation function takes a double and returns a boolean
  def processPaymentWithValidation(paymentMethod: PaymentMethod, amount: MoneyAmount, validate: Double => Boolean): Either[String, Unit] =
    Try(validate(amount.value)) match {
      case scala.util.Success(true) =>
        processPayment(paymentMethod, amount)
      case scala.util.Success(false) =>
        Left("Validation failed")
      case scala.util.Failure(exception) =>
        Left(s"Validation failed with exception: ${exception.getMessage}")
    }
}
