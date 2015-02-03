package fractal.reverseCalc

import scala._
import scala.io.StdIn

object SimpleApp extends App {
	try{
                while(true){
                  println("Please enter your input : " )
                  val line = StdIn.readLine()
                  println("Result = "+ReverseCalc.calculate(line))
                }
  }catch {
    case usoe: UnsupportedOperationException => println("This operation is not supported here")
    case nfe: NumberFormatException => println("Only numeric can be calculated")
    case e: Exception => println("Exception occured")
  }

}
