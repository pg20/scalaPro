package scala99.tree


sealed abstract class Tree[+T] {
  def leafCount: Int
  def leafList: List[T]
  def internalList: List[T]
  def preOrderTraversal: List[T]
  def inorderTraversal: List[T]
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
  def leafCount: Int = (left, right) match {
    case (End, End) => 1
    case _          => left.leafCount + right.leafCount
  }

  def leafList: List[T] = (left, right) match {
    case (End, End) => List(value)
    case _          => left.leafList ::: right.leafList
  }

  def internalList: List[T] = (left, right) match {
    case (End, End) => Nil
    case _          => value :: left.internalList ::: right.internalList
  }
  def preOrderTraversal: List[T] = value :: left.preOrderTraversal ::: right.preOrderTraversal

  def inorderTraversal: List[T] = left.inorderTraversal ::: value :: right.inorderTraversal


}

case object End extends Tree[Nothing] {
  override def toString = "."
  def leafCount: Int = 0
  def leafList = Nil
  def internalList = Nil
  def preOrderTraversal = Nil
  def inorderTraversal = Nil


}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

//Construct completely balanced binary trees.
//In a completely balanced binary tree, the following property holds for every node: The number of nodes in its left subtree and the number of nodes in its right subtree are almost equal, which means their difference is not greater than one.
//Define an object named Tree. Write a function Tree.cBalanced to construct completely balanced binary trees for a given number of nodes. The function should generate all solutions. The function should take as parameters the number of nodes and a single value to put in all of them.
//
//scala> Tree.cBalanced(4, "x")
//res0: List(Node[String]) = List(T(x T(x . .) T(x . T(x . .))), T(x T(x . .) T(x T(x . .) .)), ...

object P55 {

  def cBalanced[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
    case n if n < 1 => List(End)
    case n if n % 2 == 1 => {
      val subTrees = cBalanced(n / 2, value)
      subTrees.flatMap(lt => subTrees.map(rt => Node(value, lt, rt)))
    }

    case n if n % 2 == 0 => {
      val lesserSubTrees = cBalanced((n - 1)/ 2, value)
      val greaterSubTress = cBalanced((n - 1) / 2 + 1, value)
      lesserSubTrees.flatMap(lsub => greaterSubTress.flatMap(rsub => List(Node(value, lsub, rsub), Node(value, rsub, lsub))))
    }

  }

  def main(args: Array[String]): Unit = {
    println(P55.cBalanced(4, "x"))
    println(Node('x', Node('x'), End).leafCount)
    val tree1 =  Node('a', Node('b'), Node('c', Node('d'), Node('e')))
    println(tree1.leafList)
    println(tree1.internalList)
    println(tree1.toString)
    println("preorder traversal", tree1.preOrderTraversal)
    println( "inorder traversal" , tree1.inorderTraversal)
  }


}
