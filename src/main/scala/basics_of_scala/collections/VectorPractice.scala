package basics_of_scala.collections

object VectorPractice extends App {

  //creating a vector
  val fruitList = Vector(1, 2, 3, 4, 5)
  fruitList.foreach(println)

  //accessing a vector
  println(s"${fruitList(1)}")

  //adding an element
  val fruitList1 = fruitList :+ 6
  val fruitList2 = 6 +: fruitList1
  val fruitList3 = fruitList1 ++ fruitList1


  fruitList2.foreach(x => println(s"added 6 ${x}"))
  fruitList3.foreach(x => println(s"concat string ${x}"))





}
