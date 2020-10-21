package basics_of_scala.traits


//Sealed provides exhaustive checking for our application.
// Exhaustive checking allows to check that all members of a sealed trait must be declared in the same file as of the source file.
// That means that all the possible known members of a trait that must be included are known by the compiler in advance.
// So this gives us advantage to prevent mistakes in our code.

sealed trait geeks {
  val article = "not done"
}

class scala extends geeks {
  override val article: String = "scala class"
}

class java extends geeks {
  override val article: String = "java class"

}

object sealedTraitPractice {

  def main(args: Array[String]): Unit = {
      val s = new scala
      val h = new java
      println(checkArticle(s))
      println(checkArticle(h))

  }

  def checkArticle(article: geeks): Unit = article match {
    case s: scala => s.article
    //case j: java => j.article
  }

  //throw match error
  // Exception in thread "main" scala.MatchError: basics_of_scala.traits.java@c39f790 (of class basics_of_scala.traits.java)

}
