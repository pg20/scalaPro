package scala99

//P22 (*) Create a list containing all integers within a given range.
//Example:
//scala> range(4, 9)
//res0: List[Int] = List(4, 5, 6, 7, 8, 9)


object P22 {

  def rangeUsingFn(start: Int, end: Int) = {
    List.range(start, end)
  }

  def rangeBuiltIn(start: Int, end: Int) = {
    def rangeBuiltInFill(result: List[Int], start: Int, end: Int, cnt: Int): List[Int] = {
      if (cnt >= start && cnt < end) {
         rangeBuiltInFill(cnt :: result, start, end, cnt + 1)
      } else {
        result.reverse
      }
    }
    rangeBuiltInFill(List[Int](), start, end, start)

  }

  //Classic FUnctional approach using unflodr
  //New approach
  def unfoldRight[A, B](s: B)(f: B => Option[(A, B)]): List[A] = f(s) match {
    case None => Nil
    case Some((r, n)) => r :: unfoldRight(n)(f)
  }
  def rangeFunctional(start: Int, end: Int): List[Int] =
    unfoldRight(start) { n =>
      if (n > end) None
      else Some((n, n + 1))
    }


  def main(args: Array[String]) = {
      println(P22.rangeBuiltIn(4, 10))
      println(P22.rangeUsingFn(100, 110))
      println(P22.rangeFunctional(4, 10))
  }

}
