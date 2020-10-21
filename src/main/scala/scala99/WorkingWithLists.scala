package scala99

import scala.reflect.ClassTag

//http://aperiodic.net/phil/scala/s-99/
//P01 (*) Find the last element of a list.
//Example:
//scala> last(List(1, 1, 2, 3, 5, 8))
//res0: Int = 8

//P02 (*) Find the last but one element of a list.
//Example:
//scala> penultimate(List(1, 1, 2, 3, 5, 8))
//res0: Int = 5

//P03 (*) Find the Kth element of a list.
//By convention, the first element in the list is element 0.
//Example:
//
//scala> nth(2, List(1, 1, 2, 3, 5, 8))
//res0: Int = 2

//P05 (*) Reverse a list.
//Example:
//scala> reverse(List(1, 1, 2, 3, 5, 8))
//res0: List[Int] = List(8, 5, 3, 2, 1, 1)

//P06 (*) Find out whether a list is a palindrome.
//Example:
//scala> isPalindrome(List(1, 2, 3, 2, 1))
//res0: Boolean = true


//P07 (**) Flatten a nested list structure.
//Example:
//scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
//res0: List[Any] = List(1, 1, 2, 3, 5, 8)

object WorkingWithLists {

  //P01
  def last(list: List[Int]): Int = {
    list(list.length - 1)
  }

  //P01
  def lastRecursive(list: List[Int]): Int = {
    if (list.length == 1)
      return list(0)
    lastRecursive(list.tail)
  }

  //P01
  //inserting a generic type fn in object
  def lastRecursiveMatch[T](list: List[T]): T = list match {
    case h :: Nil => h
    case _ :: tail => lastRecursiveMatch(tail)
    case _ => throw new NoSuchElementException
  }

  ///P02
  def penultimate[T](list: List[T]): T = list match {
    case a :: _ :: Nil => a
    case _ :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException

  }

  ///P02
  def penultimateBuiltin[T](list: List[T]): T = {
    if (list.isEmpty) throw new NoSuchElementException
    list.init.last
  }

  //generalised to Find Nth element from last in list
  def lastNthBuiltin[T](n: Int, ls: List[T]): T = {
    if (n <= 0) throw new IllegalArgumentException
    if (ls.length < n) throw new NoSuchElementException
    ls.takeRight(n).head
  }

  def lastNthNumberInList[T](n: Int, ls: List[T]): T = {
    def lastNthNumberInListHelper(n: Int, resultList: List[T], ls: List[T]): T =
      ls match {
        case Nil if n > 0 => throw new NoSuchElementException
        case Nil => resultList.head
        case _ :: tail =>
          if (n > 0)
            lastNthNumberInListHelper(n - 1, resultList, tail)
          else lastNthNumberInListHelper(n - 1, resultList.tail, tail)
      }

    if (n <= 0) throw new IllegalArgumentException
    lastNthNumberInListHelper(n, ls, ls)
  }


  ///P03
  def KthElementOfList[T](K: Int, ls: List[T]): T = {
    (K, ls) match {
      case (1, h :: _) => h
      case (_, _ :: tail) => KthElementOfList(K - 1, tail)
      case (_, Nil) => throw new IllegalArgumentException
    }
  }

  def KthElementOfListBuiltin[A](n: Int, ls: List[A]): A =
    if (n >= 0) ls(n)
    else throw new NoSuchElementException


  //P04
  def lengthOfList[T](ls: List[T]): Int = {

      def lengthOfListHelper[T](cnt: Int, ls: List[T]): Int = {

          ls match {
              case Nil => cnt
              case _ :: tail => lengthOfListHelper(cnt + 1, tail)
          }
      }
      lengthOfListHelper (0, ls)

  }

  //P04
  def lengthFunctional[A](ls: List[A]): Int = ls.foldLeft(0) {
    (c, _) => c + 1
  }

  //P05
  def reverseList[T](ls: List[T]): List[T] = {
    def reverseListHelper[T](ls: List[T]): List[T] = ls match {
      case h :: Nil => (h :: Nil)
      case h :: tail => reverseListHelper(tail) :+ h
    }
    reverseListHelper(ls)
  }

  def reverseListTailRecursion[T](ls: List[T]): List[T] = {
    def reverseListHelper[T](ls: List[T], ls1: List[T]): List[T] = ls match {
      case Nil => ls1
      case h :: tail => {
        reverseListHelper(tail, h +: ls1)
      }
    }
    reverseListHelper(ls, Nil)
  }

  //P06 (*) Find out whether a list is a palindrome.
  def isPalindrome[T](ls: List[T]): Boolean = {
    ls == ls.reverse
  }

  //P07
  def flattenList[T](ls : List[Any]): List[Any] = {
    def flattenListHelper[T](ls : List[Any]): List[Any] = ls flatMap { ele =>
      ele match {
        case ms: List[Any] => flattenListHelper(ms)
        case num: T => List(num)
      }
    }
    flattenListHelper(ls)
  }





  def main(args: Array[String]) = {
      val list: List[Int] = List[Int](1, 2, 3, 4, 5, 6)
      list.init
      println(s"${last(list)}")

      println(s"${lastRecursive(list)}")

      println(s"${lastRecursiveMatch(list)}")

      println(s"${penultimate(list)}")
      val num = 4
      println(s"last $num in the list is ${lastNthBuiltin(num, list)}")
      println(s"last $num in the list is ${lastNthNumberInList(num, list)}")

      println(s"$num in the list is ${KthElementOfList(num, list)}")

      println(s"$num in the list is ${lengthOfList(list)}")
      println(s" reverse of the list is ${ reverseListTailRecursion(list)}")
      println(s" reverse of the list is ${reverseList(list)}")

      println(s" reverse of the list is ${isPalindrome(list)}")

    val list1 = List(1, List(2, 3), 4, 5, 6)
    println(s" flatten list is ${flattenList(list1)}")



  }



}
