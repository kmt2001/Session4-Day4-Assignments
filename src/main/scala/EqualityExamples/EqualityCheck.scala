package EqualityExamples

import scala.util.Try

case class EqualityCheck(
  string1: String, string2: String,
  int1: Int, int2: Int,
  double1: Double, double2: Double,
  object1: String, object2: String,
  list1: List[Int], list2: List[Int]
) {

  // Compares the two strings for equality
  def compareStrings(): Try[Boolean] = {
    Try(string1.equals(string2))
  }

  // Compares the two integers for equality
  def compareIntegers(): Try[Boolean] = {
    Try(int1 == int2)
  }

  // Compares the two doubles for inequality
  def compareDoubles(): Try[Boolean] = {
    Try(double1 != double2)
  }

  // Compares the two objects for inequality
  def compareObjects(): Try[Boolean] = {
    Try(object1.ne(object2))
  }

  // Compares the two lists for reference equality
  def compareLists(): Try[Boolean] = {
    Try(list1.eq(list2))
  }
}
