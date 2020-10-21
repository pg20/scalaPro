package scala99

//P21 (*) Insert an element at a given position into a list.
//Example:
//scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
//res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

object P21 {

  def insertAtFunctional[T](ls: List[T], pos: Int, ele: T): List[T] = ls.splitAt(pos) match {
    case (pre, post) => pre ::: (ele :: post)
  }

  def main(args: Array[String]): Unit  = {
    val ls = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(P21.insertAtFunctional(ls, 6, 10))

  }

}
