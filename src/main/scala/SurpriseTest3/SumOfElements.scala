package SurpriseTest3

import scala.annotation.tailrec
import scala.util.{Try, Success, Failure}

class ListSummation {
  /**
   * A method to compute the sum of a list of integers using tail recursion.
   * The @tailrec annotation ensures that the method is tail-recursive, which means that
   * it uses constant stack space and can handle large input lists without overflowing the stack.
   *
   * @param list The list of integers to be summed.
   * @param sumSoFar The sum of integers computed so far.
   * @return The sum of all integers in the list, or an error message if the input is invalid.
   */
  @tailrec
  final def sum(list: List[Int], sumSoFar: Int): Either[String, Int] = {
    Try(list.head) match {
      // If the list is empty, return the sum computed so far
      case Failure(_) if list.isEmpty => Right(sumSoFar)
      // If the list has only one element, add it to the sum computed so far and return
      case Failure(_) if list.length == 1 => Right(sumSoFar + list.head)
      // If the list has more than one element, add the first element to the sum computed so far
      // and recursively call the function with the tail of the list and the updated sum
      case Success(head) => sum(list.tail, sumSoFar + head)
      // If the input is invalid (e.g., non-integer elements), return an error message
      case Failure(_) => Left("Invalid input")
    }
  }
}
