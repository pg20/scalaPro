package basics_of_scala.AccessModifiers

//https://www.geeksforgeeks.org/access-modifiers-in-scala/
//These modifiers will restrict accesses to the members to specific regions of code.
//There are Three types of access modifiers available in Scala:
//
//Private
//Protected
//Public
//Table:
//
//MODIFIER	           CLASS	COMPANION	SUBCLASS	PACKAGE	WORLD
//No Modifier/Public	   Yes	  Yes	         Yes	   Yes	  Yes
//Protected	             Yes	  Yes	         Yes	   No   	No
//Private	               Yes	  Yes	          No	   No 	  No

//What is companion in above table? It is a singleton object named same as the class.


class AccessModifiers {

  private var a: Int = 123

  def display(): Unit = {
    a = 8
    println(8)
  }

}

object Test extends App {
    val accessModifiers: AccessModifiers = new AccessModifiers
     accessModifiers.display()
}

