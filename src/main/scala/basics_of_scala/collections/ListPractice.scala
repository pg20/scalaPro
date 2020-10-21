package basics_of_scala.collections

object ListPractice extends App {

  //create list
  val fruitList = List("Apple", "Orange", "Hifi")
  val fruitList1 = List.range(1, 5)
  val fruitList2 = List.fill(10)("hello")
  val fruitList3 = "apple" :: "orange" :: "banana":: Nil
  fruitList.foreach(println)
  fruitList1.foreach(x => println(s" range is ${x}"))
  fruitList2.foreach(println)
  fruitList3.foreach(println)

  //access list

  //add element in list

  //adding element before - prepend

  val newfruitlist = "orange" :: fruitList
  // cannot do this val newfruitList2 = newfruitlist :: "hello"

  //:: is a method, known as cons, which takes two arguments.
  // The first argument is the head and is a single element.
  // The second argument is a tail which is another List.
  // nil is used to represent an empty List and is always used when constructing a List with ::.

  val newfruitList1 = newfruitlist :+ "peach"
  val newfruitList2 = "peach" +: newfruitlist
  //newfruitList1.foreach(x => println(s" fruitlist1  ${x}"))
  //newfruitList2.foreach(x => println(s" fruiltlist2 ${x}"))
  val fruitList5 = newfruitList1 ::: newfruitList2
  fruitList5.foreach(x => println(s" fruiltlist5 ${x}"))



  //remove element in list



  // more fns

  //access head/tail
  //In Scala, the tail does not refer to the last element, rather, it refers to the remaining list after the head.
  // This is why when we called the tail method above, we got the complete list excluding the head element, i.e., pear.
  println(s"${fruitList5.head}")
  println(s"${fruitList5.tail}")

  List.concat(fruitList5, fruitList5)

  println(List("a","b","c") mkString("."))
  val mergeEleList = List("a","b","c").foldLeft("")((accum, ele) => accum + "." + ele)
  println(mergeEleList)






}
