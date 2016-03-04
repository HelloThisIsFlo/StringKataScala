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
    segments.foldLeft(0)(_.toInt + _)
//    segments.foldLeft(0)(_ + _.toInt)
  }



}

class WrongFormatException extends Exception
