package basics_of_scala.collections

import scala.collection.mutable.ArrayBuffer

object ArrayBufferPractice extends App {


      var arrb1 = new ArrayBuffer[Int]
      arrb1.foreach(println)
      //adding an element in array
      arrb1 += 1
      arrb1 += 2
      arrb1 += 3
      arrb1 += 4
      arrb1 += 5

      arrb1.foreach(println)
      arrb1 -= 3
      arrb1.remove(0)
      arrb1.foreach(x => println(s"after removing ele $x"))
      arrb1.insert(0, 1)
      arrb1.foreach(x => println(s"after using insert ele $x"))
      //arrb1.

      println(s"${arrb1(0)}")

      //Not working
      arrb1.clear()
      arrb1 = ArrayBuffer[Int](2, 4, 6, 8, 10)
      arrb1.foreach(println)

      arrb1.update(0, 1)

}
