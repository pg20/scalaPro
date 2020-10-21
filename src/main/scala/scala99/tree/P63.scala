package scala99.tree

//P63 (**) Construct a complete binary tree.
//A complete binary tree with height H is defined as follows: The levels 1,2,3,...,H-1 contain the maximum number of nodes (i.e 2(i-1) at the level i, note that we start counting the levels from 1 at the root). In level H, which may contain less than the maximum possible number of nodes, all the nodes are "left-adjusted". This means that in a levelorder tree traversal all internal nodes come first, the leaves come second, and empty successors (the Ends which are not really nodes!) come last.
//Particularly, complete binary trees are used as data structures (or addressing schemes) for heaps.
//
//We can assign an address number to each node in a complete binary tree by enumerating the nodes in levelorder, starting at the root with number 1. In doing so, we realize that for every node X with address A the following property holds: The address of X's left and right successors are 2*A and 2*A+1, respectively, supposed the successors do exist. This fact can be used to elegantly construct a complete binary tree structure. Write a method completeBinaryTree that takes as parameters the number of nodes and the value to put in each node.
//
//scala> Tree.completeBinaryTree(6, "x")
//res0: Node[String] = T(x T(x T(x . .) T(x . .)) T(x T(x . .) .))


object P63 {

  def completeBinaryTree[T](nodes: Int, value: T) = {
      def generateTree(addr: Int): Tree[T] = {
        if (addr > nodes) End
        else {
          Node (value, generateTree(2 * addr),
            generateTree(2 * addr + 1))
        }
      }
      generateTree(1)
  }

  def main(args: Array[String]): Unit = {
    println(P55.cBalanced(4, "x"))
    println(Node('x', Node('x'), End).leafCount)
    val tree1 =  Node('a', Node('b'), Node('c', Node('d'), Node('e')))
    println(tree1.leafList)
    println(tree1.internalList)
    println(completeBinaryTree(6, 'x'))
  }


}
