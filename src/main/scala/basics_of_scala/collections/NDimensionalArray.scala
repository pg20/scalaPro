package basics_of_scala.collections

object NDimensionalArray {

  def usingOFDimFn() = {

    // create a 2D array
    val matrix = Array.ofDim[Int](2,2)
    //matrix: Array[Array[Int]] = Array(Array(0, 0), Array(0, 0))
    // populate the array elements

    //  val arrayname = Array.ofDim[data_type](number of rows, number of cols)
    //  or
    //  var arrayname = Array(Array(elements), Array(elements))

    matrix(0)(0) = 0

    matrix(0)(1) = 1

    matrix(1)(0) = 2

    matrix(1)(1) = 3

    // access a couple of array elements
    println(matrix(0)(1))

    for(i<-0 to 1; j<-0 until 2)
    {
      print(i, j)

      //Accessing the elements
      println("=" + matrix(i)(j))
    }

  }


  def usingArrayOfArray() = {
    var arr= Array(Array(0, 2, 4, 6, 8),
      Array(1, 3, 5, 7, 9))

    for(i<-0 to 1)
    {
      for(j<- 0 to 4)
      {
        // Accessing the values
        print(" "+arr(i)(j))
      }
      println()
    }
  }


}
