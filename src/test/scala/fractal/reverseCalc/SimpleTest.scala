package fractal.reverseCalc

import collection.mutable.Stack
import org.scalatest._

class SimpleTest extends FlatSpec with Matchers {


  "calculate" should
    "return result for valid arguments" in {
    println("addition test begins")
    ReverseCalc.calculate("1 2 +") should be ("3.0")
  }

  "calculate" should
    "return result for a power b" in {
    println("addition test begins")
    ReverseCalc.calculate("2 2 ^") should be ("4.0")
  }

  "factorial" should
    "return result for number" in {
    println("addition test begins")
    ReverseCalc.calculate("3 !") should be ("6")
  }

  "mail test" should
  "return exact answers" in {
    ReverseCalc.calculate("1 2 3 + -") should be ("-4.0")
    ReverseCalc.calculate("6 2 * 3 /") should be ("4.0")
    ReverseCalc.calculate("2 3 ^ 4 5 + +") should be ("17.0")
    ReverseCalc.calculate("50 % 2 *") should be ("1.0")
    ReverseCalc.calculate("3 ! 4 5 * +") should be ("26.0")
    ReverseCalc.calculate("12 3 / !") should be ("24")
    ReverseCalc.calculate("5 1 2 + 4 * + 3 -") should be ("14.0")
  }

}
