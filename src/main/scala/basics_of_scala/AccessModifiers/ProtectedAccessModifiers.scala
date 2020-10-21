package basics_of_scala.AccessModifiers


//2. Protected: They can be only accessible from sub classes of the base class in which the member has been defined.
//3. Public: There is no public keyword in Scala. The default access level (when no modifier is specified) corresponds to Java’s public access level.We can access these anywhere.

class ProtectedAccessModifiers {

  // declaration of protected member
  protected var a:Int = 123
  def display()
  {
    a = 8
    println(a)
  }
}

// class new1 extends by class gfg
class new1 extends ProtectedAccessModifiers
{
  override def display()
  {
    a = 9
    println(a)
  }
}

object access extends App
{
  // class abc is accessible because this
  // is in the same enclosing scope
  var e = new ProtectedAccessModifiers()
  e.display()
  var e1 = new new1()
  e1.display()
  var poly_e = new new1()
  poly_e.display()

}
