package scala99
import scala.reflect.ClassTag

//http://aperiodic.net/phil/scala/s-99/
//P01 (*) Find the last element of a list.
//Example:
//scala> last(List(1, 1, 2, 3, 5, 8))
//res0: Int = 8
class working_with_lists[T](implicit m: ClassTag[T]) {

  def last(list: List[Int]): Int = {
    list(list.length - 1)
  }

  def lastRecursive(list: List[Int]): Int = {
    if (list.length == 1)
      return list(0)
    lastRecursive(list.tail)
  }

  def lastRecursiveMatch(list: List[T])(implicit m: ClassTag[T]): T = list match {
    case h :: Nil => h
    case _ :: tail => lastRecursiveMatch(tail)
    case _ => throw new NoSuchElementException
  }


  def main(args: Array[String]) = {
    val list: List[Int] = List[Int](1, 2, 3, 4, 5, 6)
    println(s"${last(list)}")

    println(s"${lastRecursive(list)}")

    //println(s"${lastRecursiveMatch(list)}")


  }

}

object Test extends App {
  val list: List[Int] = List[Int](1, 2, 3, 4, 5, 6)
  val working_with_list  = new working_with_lists[Int]
  println(s"${working_with_list.lastRecursiveMatch(list)}")

  //val list: List[Int] = List[Int](1, 2, 3, 4, 5, 6)
  println(s"${working_with_list.last(list)}")

  println(s"${working_with_list.lastRecursive(list)}")

}



