package experimentations

import java.net.URL

import scala.io.StdIn
import scala.util.Try

/**
  * Created by Shock on 3/4/2016.
  */
object LearningTry {

  def buyCigarettes(customer: Customer): Beer =
    if (customer.age < 16)
      throw UnderAgeException(s"Customer must be older than 16 but was ${customer.age}")
    else Beer("Dunhill")

  def main(args: Array[String]) {
    val customer = Customer(15)
    val result = {
      try {
        buyCigarettes(customer)
        "Success! He just bought cigarettes"
      } catch {
        case UnderAgeException(msg) => msg
      }
    }

    def parseURL(url: String): Try[URL] = Try(new URL(url))

    val url = parseURL(readLine("URL: ")) getOrElse new URL("http://duckduckgo.com")

    println(url)

    println(result)
  }

  case class Customer(age: Int)

  case class Beer(brand: String)

  case class UnderAgeException(message: String) extends Exception(message)
}
