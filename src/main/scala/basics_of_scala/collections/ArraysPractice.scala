package basics_of_scala.collections

object ArraysPractice extends App {



   //def functions() = {
        val arr = Array(1, 2, 3, 5, 6)
        arr.foreach(print)

        val arr_new = new Array[Int](3)
        arr_new(0) = 1
        arr_new(2) = 2
        arr_new.foreach(print)

        val arr1 = Array.range(1, 5)
        arr1.foreach(println)

        var arr_range = Array.range(1, 10, 2)
        arr_range.foreach(x => println(s" range filled array $x"))

        val arr2 = Array.fill(5)(-1)
        arr2.foreach(println)
        val arr3 = Array.fill(2, 3)(0)
        arr3.foreach(x => x.foreach(print))
        //convert string to array
        val hello_str = "hello".toArray
        hello_str.foreach(println)
        val len = hello_str.length
        println(s"len is $len")


  // }

}
