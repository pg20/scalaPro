package basics_of_scala.collections

object ImmutableStringPractice extends App {


  val s: String = "Hello world"
  println(s" char at 4th index ${s.charAt(4)}")

  val s1: String = "Hello world1"
  val s2: String = "Hello World1"

  println(s" comparing 2 strings  using compareTo ${s1.compareTo(s)}")
  println(s" comparing 2 strings using compareToIgnoreCase ${s2.compareToIgnoreCase(s)}")
  println(s" comparing 2 strings using equals ${s2.equals(s)}")
  println(s" comparing 2 strings using equalsIgnoreCase ${s2.equalsIgnoreCase(s)}")

  val s3 = s1 + " "  + s2
  println(" concat string "  + s3)

  val s3contains = s3.endsWith("World1")
  println(s" ends with ${s3contains}")

  println(s" find index of o in ${s3} is ${s3.indexOf('o')}")
  println(s" find index of o  after first occurance  in ${s3} is ${s3.indexOf('o', 5)}")
  println(s" find last index of o in ${s3} is ${s3.lastIndexOf('o')}")
  println(s" find last index of o in ${s3}  from 19 is ${s3.lastIndexOf('o', 19)}")

  //replaced all occurances
  val s3replace = s3.replace('1', '2')
  println(s" replace 1 with 2 in $s3 is  ${s3replace}")

  //replaced first
  val s3replaceFirst = s3.replaceFirst("[0-9]*", "2")
  println(s" replace 1 with 2 in $s3  using regex is  ${s3replaceFirst}")



}
//charAt
//indexOf
//indexOf(T, fromIndex)
//lastIndexOf
//
//compareTo
//compareToIgnoreCase
//equals
//equalsIgnoreCase
//
//replace
//replaceFirst(str regex, str replacement)
//replaceAll
//
//substring
//toUpperCase
//toLowerCase