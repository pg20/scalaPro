package scala99


//P14 (*) Duplicate the elements of a list.
//Example:
//scala> duplicate(List('a, 'b, 'c, 'c, 'd))
//res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

//P15 (**) Duplicate the elements of a list a given number of times.
//Example:
//scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
//res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

//P16 (**) Drop every Nth element from a list.
//Example:
//scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

//P17 (*) Split a list into two parts.
//The length of the first part is given. Use a Tuple for your result.
//Example:
//
//scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

//P18 (**) Extract a slice from a list.
//Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
//Example:
//
//scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//res0: List[Symbol] = List('d, 'e, 'f, 'g)

object P14 {

  //P14
  def duplicateEle[T](ls: List[T]): List[T] = ls.flatMap(x => {
    List(x, x)
  })

  //P15
  def duplicateN[T](N: Int, ls: List[T]): List[T] = ls.flatMap(x => {
       List.fill(N)(x)
    }
  )

  //P16
  def dropNEle[T](N: Int, ls: List[T]): List[T] = {
    def dropNEleHelper[T](c: Int, result: List[T], ls: List[T]): List[T] =
      (c, ls) match {
        case (_, Nil) => result
        case (1, _ :: tail) => dropNEleHelper(N, result, tail)
        case (_, h :: tail) => dropNEleHelper(c - 1, result :+ h, tail)
      }
    dropNEleHelper(N, List[T](), ls)
  }
  //P16

  def dropNEleFunctional[T](N: Int, ls: List[T]): List[T] = {
    ls.zipWithIndex.filter(x => {
      (x._2 + 1) % N != 0
    }).map(x => x._1)
  }

  //P17

  def splitList[T](N: Int, ls: List[T]): (List[T], List[T]) = {
      def splitListRecur(c: Int, ls: List[T], resultList: List[T]):(List[T], List[T]) = (c, ls) match {
        case (_, Nil) => (resultList, Nil)
        case (0, list) => (resultList, list)
        case (_, hs :: tail) => splitListRecur(c - 1, tail, resultList :+ hs)
      }
    splitListRecur(N, ls, List[T]())
  }

  def splitListFunctional[T](N: Int, ls: List[T]): (List[T], List[T]) = {
    //(ls.dropRight(ls.length - N), ls.drop(N))
    //(ls.take(N), ls.drop(N))
    (ls.take(N), ls.drop(N))
  }

//  def slice[T](start: Int, end: Int, ls: List[T]): List[T] = ls match {
//
//  }


  def main(args: Array[String]) = {
    val ls = List('a, 'b, 'c, 'c, 'd)
    println(s"duplicate element ${duplicateEle(ls)}")
    println(s"duplicate element N times ${duplicateN(3, ls)}")

    val ls1 = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    println(s"drop N element              ${dropNEle(3, ls1)}")
      println(s"drop N element Functional ${dropNEleFunctional(3, ls1)}")

    println(s"split List ${splitList(3, ls1)._1} \n second list is ${splitList(3, ls1)._2}")
    println(s"split List using function ${splitListFunctional(3, ls1)._1} \n second list is ${splitListFunctional(3, ls1)._2}")


  }





}
