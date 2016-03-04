import scala.util.{Failure, Success, Try}

class StringCalculator {

  def add(toAdd: String): Int = {
    if (toAdd.isEmpty) {
      0
    } else {
      addNotEmpty(toAdd)
    }
  }

  def addNotEmpty(toAdd: String): Int = {
    val segments = toAdd.split(",")
    segments.foldLeft(0)((acc, current) => acc + tryToParseToInt(current))
  }

  def tryToParseToInt(toParse: String): Int = {
    val parsedInt = Try(toParse.toInt)
    parsedInt match {
      case Success(int) => int
      case Failure(msg) => throw WrongFormatException(msg.getMessage)
    }
  }
}

case class WrongFormatException(msg: String) extends Exception
