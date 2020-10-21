package scala99

import scala.reflect.ClassTag

//P25 (*) Generate a random permutation of the elements of a list.
//Hint: Use the solution of problem P23.
//Example:
//
//scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
//res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)


object P25 {

  import P23.randomSelect

  def randomPermuteFunction[T](ls: List[T]): List[T] =
    randomSelect(ls, ls.length)


  //xTo instantiate an array in a generic context (instantiating an array of T where T is a type parameter),
  // Scala needs to have information at runtime about T, in the form of an implicit value of type ClassTag[T].
  // Concretely, you need the caller of your method to (implicitly) pass this ClassTag value,
  // which can conveniently be done using a context bound:

  def randomPermute[T:ClassTag](ls: List[T]): List[T] = {
    val rand = util.Random
    val a = ls.toArray[T]
    for (i <- a.length - 1 to 1 by -1) {
        val i1 = rand.nextInt(i + 1)
        val t = a(i)
        a.update(i, a(i1))
        a.update(i1, t)
    }
    a.toList
  }

  def main(args: Array[String]): Unit = {
      val ls : List[Int] = List(1,2,3,4,5,6,7,8,9)
      println(randomPermute(ls))
  }


}
