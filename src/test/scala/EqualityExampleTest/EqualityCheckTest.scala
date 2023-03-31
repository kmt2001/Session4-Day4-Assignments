package EqualityExampleTest

import org.scalatest.funsuite.AnyFunSuite
import EqualityExamples.EqualityCheck
import scala.util.Success

class EqualityCheckTest extends AnyFunSuite {

  test("EqualityCheck.compareStrings returns true for equal strings") {
    val ec = EqualityCheck("hello", "hello", 1, 2, 1.0, 2.0, "obj1", "obj2", List(1, 2), List(1, 2))
    assert(ec.compareStrings() === Success(true))
  }

  test("EqualityCheck.compareStrings returns false for unequal strings") {
    val ec = EqualityCheck("hello", "world", 1, 2, 1.0, 2.0, "obj1", "obj2", List(1, 2), List(1, 2))
    assert(ec.compareStrings() === Success(false))
  }

  test("EqualityCheck.compareIntegers returns true for equal integers") {
    val ec = EqualityCheck("hello", "hello", 42, 42, 1.0, 2.0, "obj1", "obj2", List(1, 2), List(1, 2))
    assert(ec.compareIntegers() === Success(true))
  }

  test("EqualityCheck.compareIntegers returns false for unequal integers") {
    val ec = EqualityCheck("hello", "hello", 1, 2, 1.0, 2.0, "obj1", "obj2", List(1, 2), List(1, 2))
    assert(ec.compareIntegers() === Success(false))
  }

  test("EqualityCheck.compareDoubles returns true for unequal doubles") {
    val ec = EqualityCheck("hello", "hello", 1, 2, 1.0, 1.0, "obj1", "obj2", List(1, 2), List(1, 2))
    assert(ec.compareDoubles() === Success(false))
  }

  test("EqualityCheck.compareDoubles returns false for equal doubles") {
    val ec = EqualityCheck("hello", "hello", 1, 2, 1.0, 2.0, "obj1", "obj2", List(1, 2), List(1, 2))
    assert(ec.compareDoubles() === Success(true))
  }

  test("EqualityCheck.compareObjects returns true for unequal objects") {
    val ec = EqualityCheck("hello", "hello", 1, 2, 1.0, 2.0, "obj1", "obj2", List(1, 2), List(1, 2))
    assert(ec.compareObjects() === Success(true))
  }

  test("EqualityCheck.compareObjects returns false for equal objects") {
    val ec = EqualityCheck("hello", "hello", 1, 2, 1.0, 2.0, "obj1", "obj1", List(1, 2), List(1, 2))
    assert(ec.compareObjects() === Success(false))
  }
}