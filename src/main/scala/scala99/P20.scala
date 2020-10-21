package scala99

import java.util.NoSuchElementException


//Remove the Kth element from a list.
//Return the list and the removed element in a Tuple. Elements are numbered from 0.
//Example:
//
//scala> removeAt(1, List('a, 'b, 'c, 'd))
//res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

object P20 {

  def removeKthEle[T] (ls: List[T], K: Int): (List[T], T) = {
    def removeKthEleHelper[T](ls: List[T], resultList: List[T], K: Int): (List[T], T) = (ls, K) match {
        case (Nil, _) => throw new NoSuchElementException
        case (h :: tail, 0) => (resultList.reverse ::: tail, h)
        case (h :: tail, cnt) => removeKthEleHelper(tail, h :: resultList, cnt - 1)
    }
    if (K < 0) throw new NoSuchElementException
    removeKthEleHelper(ls, List[T](), K)
  }

  def removeKthEleFunctional[T](n: Int, ls: List[T]): (List[T], T) = ls.splitAt(n) match{
    case (Nil, _) if n < 0 => throw new NoSuchElementException()
    case (pre, e:: post) => (pre ::: post, e)
    case (pre, Nil) => throw new NoSuchElementException
  }

  def main(args: Array[String]): Unit  = {
    val ls = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(P20.removeKthEle(ls, 6))
    println(P20.removeKthEleFunctional(6, ls))

  }

}
