package scala99


//P08 (**) Eliminate consecutive duplicates of list elements.
//If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
//Example:
//
//scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)




object P08  {

  //P08
  def removeDuplicates[T](ls: List[T], resultList: List[T]): List[T] = ls match {
    case Nil => resultList
    case h :: tail => if (!resultList.isEmpty && h == resultList.last)
      removeDuplicates(tail, resultList)
    else removeDuplicates(tail, resultList :+ h)
  }

  //using foldleft
  def removeDuplicatesFoldLeft[T](ls: List[T]): List[T] = ls.foldLeft(List[T]()) {
    (resultList, h) => if (!resultList.isEmpty && h == resultList.last) resultList
      else resultList :+ h
  }

  def compressRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil       => Nil
    case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
  }

  // Tail recursive.
  def compressTailRecursive[A](ls: List[A]): List[A] = {
    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil       => result.reverse
    }
    compressR(Nil, ls)
  }

  def main(args: Array[String]) = {
    val list: List[Int] = List[Int](1, 1, 1, 2, 3, 4, 1, 5, 6)
    println(s"${removeDuplicates(list, Nil)}")
    println(s"${removeDuplicatesFoldLeft(list)}")
    println(s"${compressRecursive(list)}")
    println(s"${compressTailRecursive(list)}")

  }

}

//P09 (**) Pack consecutive duplicates of list elements into sublists.
//If a list contains repeated elements they should be placed in separate sublists.
//Example:
//
//scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

//P10 (*) Run-length encoding of a list.
//    Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
//  Example:
//
//    scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//  res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

//P11 (*) Modified run-length encoding.
//Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
//Example:
//
//scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

//P12 (**) Decode a run-length encoded list.
//Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
//Example:
//
//scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
//res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

//P13 (**) Run-length encoding of a list (direct solution).
//Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
//Example:
//
//scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

object P09 {

  def pack[T](ls: List[T]): List[List[T]] = {
    def packHelper[T](ls: List[T], resultList: List[List[T]]): List[List[T]] = ls match {
      case Nil => resultList
      case h :: tail => if (!resultList.isEmpty  && (h == resultList.last.head))
                packHelper(tail, resultList.updated( resultList.length - 1, resultList.last :+ h))
        else if (resultList.isEmpty) {
              packHelper(tail, List(List(h)))
        } else {
        //resultList.span
            packHelper(tail, resultList ::: List(List(h)))
        }
    }
    packHelper(ls, Nil)
  }

  def packSpan[T](ls: List[T]) : List[List[T]] = {
      if (ls.isEmpty)
        List(List())
      else {
        val (packed, next) = ls span {_ == ls.head }
        if (next == Nil)
          List(packed)
        else packed :: pack(next)
      }
    }

  //P10
  def runLengthEncoding[T](ls: List[List[T]]): List[(Int, T)] = ls.map( x => {
                (x.length, x.head)})

  //P11
  def runLengthEncodingModify[T](ls: List[List[T]]): List[Any] = ls.map( x => x match {
    case h :: Nil => h
    case h :: _ => (x.length, h)
  })

  //P12
  def decodeRunLengthEncoded[T](rle :List[(Int, T)]): List[T] = rle.flatMap( x => {
    List.fill(x._1)(x._2)
  })

  //P13
  def directRLE[T](rle: List[T]): List[(Int, T)] = {
    if (rle.isEmpty) {
      List[(Int, T)]()
    } else {
      val (packed, next) = rle.span(_ == rle.head)
      (packed.length, packed.head) :: directRLE(next)
    }

  }




  def main(args: Array[String]) = {
    val ls : List[Symbol]  = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      //List(Symbol("a"), Symbol("a"), Symbol("a"), Symbol("a"), Symbol("b"), Symbol("c"), Symbol("c"), Symbol("a"),
      //Symbol("a"), Symbol("d"), Symbol("e"), Symbol("e"), Symbol("e"), Symbol("e"))
    println("pack of " + pack(ls))
    println("pack of " + packSpan(ls))
    println("run length encoding " + runLengthEncoding(packSpan(ls)))
    println("run length encoding modify  " + runLengthEncodingModify(packSpan(ls)))
    println("run length encoding modify  " + decodeRunLengthEncoded(runLengthEncoding(packSpan(ls))))
    println("direct run length encoding " + directRLE(ls))




  }
}

