import org.scalatest.{BeforeAndAfter, FunSuite}

class StringCalculatorTest extends FunSuite with BeforeAndAfter{

  var calculator:StringCalculator = _

  before {
    calculator = new StringCalculator
  }

  test("Empty string -> returns 0") {
    val emptyString = ""
    val result = calculator.add(emptyString)

    assert(0 == result)
  }

  test("Single number -> return number") {
    val singleNumber = "12"
    val result = calculator.add(singleNumber)

    assert(12 == result)
  }

  test("Multiple number separated by comma -> return Sum") {
    val multipleNumbers = "12,44,553"
    val result = calculator.add(multipleNumbers)

    assert(12 + 44 + 553 == result)
  }

  test("Wrong input -> Exception") { //todo might wanna do with Option or Either
    val wrongFormat = "12,dd,45"
    intercept[WrongFormatException] {
      calculator.add(wrongFormat)
    }
  }

  test("New line delimiter -> Returns Sum") {
    val numbersWithNewLineDelimiter = "213,44\n11,5\n566\n1"

    val result = calculator.add(numbersWithNewLineDelimiter)
    assert(213 + 44 + 11 + 5 + 566 + 1 == result)
  }

  test("Custom delimiter -> Detects the delimiter and returns Sum") {
    val numbersWithCustomDelimiter = "//d\n13d2,45\n454d3"

    val result = calculator.add(numbersWithCustomDelimiter)
    assert(13 + 2 + 45 + 454 + 3 == result)
  }
}
