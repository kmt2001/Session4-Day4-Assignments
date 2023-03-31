## Assignment-1
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

## Assignment-2

The above project defines a case class named EqualityCheck which has properties for two strings, two integers, two doubles, two objects and two lists of integers. The case class also has five methods that compare the properties of two instances of the class for equality or inequality. The methods return a Try object which wraps a boolean value indicating the result of the comparison.

The driver code creates two instances of EqualityCheck and calls the five comparison methods on them to demonstrate their functionality. The results are printed to the console.


## Surprise Test Description

This code defines a class called ListSummation with a method called sum, which takes a list of integers and computes their sum using tail recursion. The method has the following features:

The @tailrec annotation ensures that the method is tail-recursive, which means that it uses constant stack space and can handle large input lists without overflowing the stack.
The method takes two parameters: list, which is the list of integers to be summed, and sumSoFar, which is the sum of integers computed so far.
The method returns an Either type that can either hold the final sum or an error message if the input is invalid (e.g., non-integer elements).
The method uses pattern matching to handle different cases of the input list. If the list is empty, it returns the sum computed so far. If the list has only one element, it adds it to the sum computed so far and returns. If the list has more than one element, it adds the first element to the sum computed so far and recursively calls the function with the tail of the list and the updated sum. If the input is invalid, it returns an error message.
 

