package basics_of_scala.collections

import scala.concurrent.Future

object ImpFns extends App{

  //to search a char in list and split it
  val ls = List.range('a', 'z')
  val (beforeP, afterP) = ls.span(_ != 'p')
  println(beforeP)
  println(afterP)
  //output
  //  List(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o)
  //  List(p, q, r, s, t, u, v, w, x, y)

  import scala.util.{Success, Failure}

  val f: Future[List[String]] = Future {
    //session.getRecentPosts
  }

  f onComplete {
    case Success(posts) => for (post <- posts) println(post)
    case Failure(t) => println("An error has occurred: " + t.getMessage)
  }

}
