package scala99

import java.util.NoSuchElementException


//P23 (**) Extract a given number of randomly selected elements from a list.
//Example:
//scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
//res0: List[Symbol] = List('e, 'd, 'a)
//Hint: Use the solution to problem P20


object P23 {

  def removeKthEle[T] (ls: List[T], K: Int): (List[T], T) = {
    def removeKthEleHelper[T](ls: List[T], resultList: List[T], K: Int): (List[T], T) = (ls, K) match {
      case (Nil, _) => throw new NoSuchElementException
      case (h :: tail, 0) => (resultList.reverse ::: tail, h)
      case (h :: tail, cnt) => removeKthEleHelper(tail, h :: resultList, cnt - 1)
    }
    if (K < 0) throw new NoSuchElementException
    removeKthEleHelper(ls, List[T](), K)
  }

  def randomSelect[T](ls: List[T], n: Int): List[T] = {
    def randomSelectHelper[T](ls: List[T], n: Int, r: util.Random): List[T] = {
        if (n <= 0) Nil
        else {
           val (rest, e) = removeKthEle(ls, r.nextInt(ls.length))
           e :: randomSelectHelper(rest, n - 1, r)
        }
    }
    randomSelectHelper(ls, n, new util.Random)

    }

  def main(args: Array[String]) = {
    val ls = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(P23.randomSelect(ls, 3))
  }



}
