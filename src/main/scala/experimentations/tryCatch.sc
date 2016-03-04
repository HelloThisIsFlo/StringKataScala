import java.net.URL

import experimentations.LearningTry.{Customer, Beer, UnderAgeException}

import scala.util.Try

def parseURL(url: String): Try[URL] = Try(new URL(url))

val url = parseURL("http://www.google.com").map(_.getProtocol)

val url2 = url getOrElse new URL("http://duckduckgo.com")

println(url)

def buyCigarettes(customer: Customer): Beer =
  if (customer.age < 16)
    throw UnderAgeException(s"Customer must be older than 16 but was ${customer.age}")
  else Beer("With alcool")

def tryToBuyCigarettes(customer: Customer): Try[Beer] = Try(buyCigarettes(customer))
val result = tryToBuyCigarettes(Customer(19)) getOrElse Beer("alcoohl free")