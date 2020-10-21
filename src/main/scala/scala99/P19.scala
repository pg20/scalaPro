package scala99


//Rotate a list N places to the left.
//Examples:
//scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
//
//scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

object P19 {

  def rotate[T](n: Int, ls: List[T]): List[T] = {
      val total_rotate_ele = if (ls.isEmpty) 0 else n % ls.length
      if (total_rotate_ele < 0) rotate(total_rotate_ele + ls.length, ls)
      else (ls drop total_rotate_ele) ::: (ls take total_rotate_ele)

  }


}
