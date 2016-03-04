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
    val segments = toAdd.split(makeSplitRegex())
    segments.foldLeft(0)((acc, current) => acc + tryToParseToInt(current))
  }

  def tryToParseToInt(toParse: String): Int = {
    val parsedInt = Try(toParse.toInt)
    parsedInt match {
      case Success(int) => int
      case Failure(msg) => throw new WrongFormatException(s"Impossible to parse $toParse")
    }
  }

  def makeSplitRegex(): String = {
    "[,\\n]"
  }
}

class WrongFormatException(message: String) extends Exception(message)

