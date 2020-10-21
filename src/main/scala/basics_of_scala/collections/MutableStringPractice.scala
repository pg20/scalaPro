package basics_of_scala.collections


//need when repeated modifications to a string
//StringBuilder is utilized to append input data to the internal buffer
//source https://www.geeksforgeeks.org/stringbuilder-in-scala/

object MutableStringPractice {

  def main(args: Array[String]) = {

      //mutable variable: used var
      var x1 = new StringBuilder("Hello variable")
      (x1 ++= " tested")
      println(x1)

      //create a string: used val
      val x = new StringBuilder("Hello ")



      // insert char in string
      val y = (x += 's')
      println(y)

      //insert multiple chars in string
      val z = (x ++= " of GeeksForGeeks")
      println(z)

      //inserting a number
     val a = z.append(800)
     println(a)

     val b = x.insert(6, "World")
     println(b)


    //deleting a character
     val q = x.delete(1, 3)
    //this will delete all the numbers indexed from 1 to 3 (excluding 3)
    println(q)
    val r = q.toString
    println(r)
    q.clear()






  }




}
