package basics_of_scala.AccessModifiers
//I was trying below java code to convert it in scala
// but i was not able to call superclass constructor from child class in scala. How do i solve this problem.
//
////java code
//class A
//{
//  public A(String a){}
//  public A(String a, int b){}
//}
//class B extends A
//{
//  public B(String c){
//    super(c);
//  }
//  public B(String c,int d){
//    super(c,d);//how to do this in scala
//  }
//}

//How to call constrtuctor of parent class in child class
//Unlike in Java, in Scala there is a single 'primary' constructor
// and all other constructors must eventually chain to it.

//This is a bit of a trick question,
// because you can control the superclass constructor that’s called by the primary constructor in a subclass,
// but you can’t control the superclass constructor that’s called by an auxiliary constructor in the subclass.

class SuperConstructor (var message: String, var num: Int)
{

  println(message+num)

  // Auxiliary constructor (2)
  def this (message: String)
  {
    this(message, 0)

  }

}

// Calling the super class constructor with 2 arguments
class SubConstructorclass (message: String) extends SuperConstructor (message, 3000)
{
  def display()
  {
    println("Subclass constructor called")
  }
}


 //Scala program to illustrate
 //calling a specific super class constructor

// Primary constructor (1)
////////////////////////////////////////////////////

class GFG (var message: String, var num: Int)
{

  println(message + num)

  // Auxiliary constructor (2)
  def this (message: String)
  {

    this(message, 1)
    println("in aux construtor")

  }

}

// Calling the superclass constructor with 2 arguments
class Subclass (message: String) extends GFG (message) //this can be call to auxilliary contructor or primary contructor . But the call will happen only after extend
{
  def display()
  {
    println("Subclass constructor called")
  }
}

// Creating object
object GFG
{
  // Main method
  def main(args: Array[String])
  {

    // Creating object of Subclass
    var obj = new Subclass("Article Count ");
    obj.display();
    val obj1: SubConstructorclass = new SubConstructorclass("Article Count ")
    obj1.display()
  }
}

//However note that in scala -- because of the well established facility of companion objects and apply methods (you can think of them as static factory methods in Java),
// I do not see people using a lot of non-primary constructors.
// They use several apply methods instead so your primary constructor generally takes all possible parameters.
// Another option is to have them use default values.
// So you very rarely need non-primary constructors and chaining.


