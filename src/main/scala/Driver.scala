import paymentSystem._

object Driver extends App {

  // Create a new payment system state
  var state = PaymentSystem.initialState

  // Add some payment methods
  state = PaymentSystem.addPaymentMethod(CreditCard("1234 5678 9012 3456", "12/23"))(state)
  state = PaymentSystem.addPaymentMethod(PayPal("user@example.com"))(state)
  state = PaymentSystem.addPaymentMethod(BankTransfer("123456789"))(state)

  // Get a list of all payment methods
  private val allPaymentMethods = PaymentSystem.getPaymentMethods(state)
  println("All payment methods:")
  allPaymentMethods.foreach(println)

  // Get a list of all credit cards
  private val creditCards = PaymentSystem.getCreditCards(state)
  println("All credit cards:")
  creditCards.foreach(println)

  // Get the total number of bank transfers
  private val totalBankTransfers = PaymentSystem.getTotalBankTransfers(state)
  println(s"Total number of bank transfers: $totalBankTransfers")

  // Process a payment using a credit card
  private val paymentResult1 = PaymentSystem.processPayment(CreditCard("1234 5678 9012 3456", "12/23"), MoneyAmount(100.0))
  println(s"Payment result 1: $paymentResult1")

  // Process a payment using PayPal with validation
  private val paymentResult2 = PaymentSystem.processPaymentWithValidation(PayPal("user@example.com"), MoneyAmount(200.0), amount => amount <= 1000.0)
  println(s"Payment result 2: $paymentResult2")

}
