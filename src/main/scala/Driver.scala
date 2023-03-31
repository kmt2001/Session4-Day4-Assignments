import paymentSystem._
import EqualityExamples._
import SurpriseTest3.ListSummation

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

  //--------------------------------------------------------------------------------------------//

  //Driver code for equality check
  private val equalityCheck1 = EqualityCheck(
    string1 = "hello", string2 = "world",
    int1 = 42, int2 = 42,
    double1 = 3.14, double2 = 2.71,
    object1 = "obj1", object2 = "obj2",
    list1 = List(1, 2, 3), list2 = List(1, 2, 3)
  )

  private val equalityCheck2 = EqualityCheck(
    string1 = "scala", string2 = "scala",
    int1 = 100, int2 = 200,
    double1 = 1.23, double2 = 1.23,
    object1 = "obj3", object2 = "obj4",
    list1 = List(4, 5, 6), list2 = List(4, 5, 6)
  )

  // Compare strings
  println(s"Strings equality: equalityCheck1.compareStrings() = ${equalityCheck1.compareStrings()}")
  println(s"Strings equality: equalityCheck2.compareStrings() = ${equalityCheck2.compareStrings()}")

  // Compare integers
  println(s"Integers equality: equalityCheck1.compareIntegers() = ${equalityCheck1.compareIntegers()}")
  println(s"Integers equality: equalityCheck2.compareIntegers() = ${equalityCheck2.compareIntegers()}")

  // Compare doubles
  println(s"Doubles inequality: equalityCheck1.compareDoubles() = ${equalityCheck1.compareDoubles()}")
  println(s"Doubles inequality: equalityCheck2.compareDoubles() = ${equalityCheck2.compareDoubles()}")

  // Compare objects
  println(s"Objects inequality: equalityCheck1.compareObjects() = ${equalityCheck1.compareObjects()}")
  println(s"Objects inequality: equalityCheck2.compareObjects() = ${equalityCheck2.compareObjects()}")

  // Compare lists
  println(s"Lists reference equality: equalityCheck1.compareLists() = ${equalityCheck1.compareLists()}")
  println(s"Lists reference equality: equalityCheck2.compareLists() = ${equalityCheck2.compareLists()}")


  // Driver code for List Summation.
  val list1 = List(1, 2, 3, 4, 5)
  private val result1 = new ListSummation().sum(list1, 0)
  println(s"Sum of $list1: $result1")

  val list2 = List()
  private val result2 = new ListSummation().sum(list2, 0)
  println(s"Sum of $list2: $result2")

  private val list3 = List(1)
  private val result3 = new ListSummation().sum(list3, 0)
  println(s"Sum of $list3: $result3")
}