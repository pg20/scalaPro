package scala99.tree

//p67: A string representation of binary trees.
//Somebody represents binary trees as strings of the following type (see example opposite):
//a(b(d,e),c(,f(g,)))
//Write a method which generates this string representation, if the tree is given as usual (in Nodes and Ends). Use that method for the Tree class's and subclass's toString methods. Then write a method (on the Tree object) which does this inverse; i.e. given the string representation, construct the tree in the usual form.
//
//For simplicity, suppose the information in the nodes is a single letter and there are no spaces in the string.
//
//scala> Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))).toString
//res0: String = a(b(d,e),c(,f(g,)))
//
//scala> Tree.fromString("a(b(d,e),c(,f(g,)))")
//res1: Node[Char] = a(b(d,e),c(,f(g,)))



object P67 {

  def toString[T](tree: Tree[T]) = {

  }


  def main(args: Array[String]): Unit = {
     val tree1 =  Node('a', Node('b'), Node('c', Node('d'), Node('e')))

  }


}
