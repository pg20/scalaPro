package scala99.tree

//Count the leaves of a binary tree.
//A leaf is a node with no successors. Write a method leafCount to count them.
//scala> Node('x', Node('x'), End).leafCount
//res0: Int = 1

//61A (*) Collect the leaves of a binary tree in a list.
//A leaf is a node with no successors. Write a method leafList to collect them in a list.
//scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList
//res0: List[Char] = List(b, d, e)

//P62 (*) Collect the internal nodes of a binary tree in a list.
//An internal node of a binary tree has either one or two non-empty successors. Write a method internalList to collect them in a list.
//scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList
//res0: List[Char] = List(a, c)
//P62B (*) Collect the nodes at a given level in a list.
//A node of a binary tree is at level N if the path from the root to the node has length N-1. The root node is at level 1. Write a method atLevel to collect all nodes at a given level in a list.
//scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
//res0: List[Char] = List(b, c)
//Using atLevel it is easy to construct a method levelOrder which creates the level-order sequence of the nodes. However, there are more efficient ways to do that.


object P61_62 {

  def leafCount[T](tree: Tree[T]): Int =  tree match {
    case Node(_, End, End) => 1
    case Node(_, left, End) => leafCount(left)
    case Node(_, End, right) => leafCount(right)
    case Node(_, left, right) => leafCount(left) + leafCount(right)

  }

  def collectList[T](tree: Tree[T]): List[T] = {
    def collectListHelper[T](tree: Tree[T], resultList: List[T]): List[T] = tree match {
      case Node(value, End, End)    => value :: resultList
      case Node(value, left, End)   => collectListHelper(left, resultList)
      case Node(value, End, right)  => collectListHelper(right, resultList)
      case Node(value, left, right) => {collectListHelper(left, resultList) ::: collectListHelper(right, resultList)
      }

    }
    collectListHelper(tree, List[T]())

  }

  def collectNodesAtGivenLevel() = {

  }

  def main(args: Array[String]): Unit = {
    val tree: Tree[Char] = Node('x', Node('x'), End)
    println(leafCount(tree))
    val tree1 =  Node('a', Node('b'), Node('c', Node('d'), Node('e')))
    println(collectList(tree1))


  }

}
