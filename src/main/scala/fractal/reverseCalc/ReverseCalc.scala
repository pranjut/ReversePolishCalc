package fractal.reverseCalc

import scala.collection.mutable
import scala.util.Try
import scala.language.postfixOps

/**
 * Created with IntelliJ IDEA.
 * User: pranjut
 * Date: 2/2/15
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
object ReverseCalc {

  def calculate(input: String): String = {
    val elems: Array[String] = input.split("\\s+")
    var elemStack: mutable.Stack[String] = new mutable.Stack[String]()

    def calcTwoNum(fn: (Float,Float) => Float) = {
      println(elemStack.mkString(" "))
      val b = elemStack.pop().toFloat
      val a = elemStack.pop().toFloat
      val res = fn(a,b)
      elemStack.push(res+"")
      println(elemStack.mkString(" "))
    }

    for(elem <- elems){
      elem match {
        case "+" => {
          calcTwoNum((a,b)=> a+b)
        }
        case "-" => {
          calcTwoNum((a,b)=> a-b)
        }
        case "*" => {
          calcTwoNum((a,b)=> a*b)
        }
        case "/" => {
          calcTwoNum((a,b)=> a/b)
        }
        case "^" => {
          calcTwoNum((a,b)=> Math.pow(a,b).toFloat)
        }
        case "%" =>{
          println(elemStack.mkString(" "))
          val a = elemStack.pop()
          val res = a.toFloat/100
          elemStack.push(res+"")
          println(elemStack.mkString(" "))
        }
        case "!" => {
          println(elemStack.mkString(" "))
          val a = Try{ elemStack.pop().toFloat } toOption match {
            case None => throw new NumberFormatException
            case Some(x) => Try {x.toInt} toOption match {
              case None => throw new UnsupportedOperationException
              case Some(y)=> y
            }
          }
          val res = factorial(1, a)
          elemStack.push(res+"")
          println(elemStack.mkString(" "))
        }
        case num : String=> {
          Try { num.toInt}.toOption match {
            case None => Try {num.toFloat}.toOption match{
              case None => throw new NumberFormatException
              case Some(fX)=>elemStack.push(fX+"")
            }
            case Some(x) => elemStack.push(x+"")
          }
        }
      }
    }
    elemStack.size match {
      case 1 => elemStack.pop()
      case _ => throw new UnsupportedOperationException
    }
  }

  def factorial(res: Int, number: Int): Int= {
   if(number == 1)
     res
    else
     factorial(number*res, number-1)
  }
}
