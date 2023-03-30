## Question:

Build a payment system for an e-commerce website where users can make payments using different payment methods such as credit cards, PayPal, and bank transfers.
Write a modular program that can perform the following operations:

    Add a new payment method with the details (Pick from credit cards, PayPal, and bank transfers. You can add multiple payment methods)
    Process a payment
    List all the added payment methods

> Take care of the abstraction
> Write unit test cases with 90%+ code coverage



## This project defines a payment system in Scala with the following functionality:

    It defines three types of payment methods: CreditCard, PayPal, and BankTransfer.
    It defines a MoneyAmount value object to represent the amount of money being paid.
    It defines a PaymentSystemState case class to represent the state of the payment system, which includes a vector of payment methods.
    It defines functions to add a payment method, process a payment using a payment method and amount, get a list of all payment methods, get a list of all credit cards that have been added, and get the total number of bank transfers that have been added.
    It defines a function to process a payment with validation, where the validation function takes a double and returns a boolean. If the validation function returns true, the payment is processed using the given payment method and amount. If it returns false, an error message is returned. If the validation function throws an exception, an error message is returned.

