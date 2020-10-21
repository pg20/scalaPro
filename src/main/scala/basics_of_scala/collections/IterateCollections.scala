package basics_of_scala.collections

object IterateCollections {


  //String
  def iterateString() = {
    //source https://alvinalexander.com/scala/how-to-process-characters-in-string-map-for-yield-foreach/

    val s: String = "Hello World"
    ////////////////1.  way is to use ////////////////////////////
    for (str <- s)
      print(str)
    ////////////////////////////// 2. way is  ////////////////////////////
    println("\n")
    for (i <- 0 until s.length)
      print (s(i))

    ////////////// 3. way is  //////////////////
    val upper = "hello, world".map(c => c.toUpper)
    println(upper)

    // write your own method that operates on a character
    def toLower(c: Char): Char = (c.toByte+32).toChar
    // use that method with map
    "HELLO".map(toLower)

    //////////// 4th: way is //////////////////
    val upper1 = for (c <- "hello, world") yield c.toUpper
    //Adding yield to a for loop essentially places the result from each loop iteration into a temporary holding area.
    // When the loop completes, all of the elements in the holding area are returned as a single collection.



    //following 2 are equivalent
    //1. val upper = "hello, world".filter(_ != 'l').map(_.toUpper)
    //2.
    //    val result = for {
    //      c <- "hello, world"
    //      if c != 'l'
    //    } yield c.toUpper

    ////////////////////////// 5th way is: ////////////////////////
    "hello".foreach(println)

  }

  def iterate2Collections(): Unit = {

      //in this zip fn iterate till one of them reaches the end
       val a = 1 to 5
       val b = 2 to 10 by 2
       for(
        (x,y) <- a.zip(b)
       )
        println(x+y)

  }

  def main(str: Array[String]) = {
    iterateString()
  }


}
