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

  test("Wrong input -> Exception") {
    val wrongFormat = "12,dd,45"
    intercept[WrongFormatException] {
      calculator.add(wrongFormat)
    }
  }
}
