package basics_of_scala.collections

object ImmutableSetPractice extends App{

  //create set
  val fruit = Set("orange", "banana", "cherry")

  //access set
  println(fruit("abc")) //return true or false
  println(fruit.contains("banana")) //return true or false


  //add elements in set
  val fruit1 = fruit + ("apple")
  val fruit2 = fruit ++ fruit1
  println(fruit1)
  println(fruit2)

  //remove elements in set
  val fruit3 = fruit1 - ("cherry")
  val fruit4 = fruit1 -- fruit3
  println(fruit3)
  println(fruit4)


  //Set operations for union, intersection, and set difference.
  // Each of these operations exists in two forms: alphabetic and symbolic.
  // The alphabetic versions are intersect, union, and diff, whereas the symbolic versions are &, |, and &~.
  // In fact, the ++ that Set inherits from Traversable can be seen as yet another alias of union or |,
  // except that ++ takes a Traversable argument whereas union and | take sets.

//  Binary Operations:
//    xs & ys	The set intersection of xs and ys.
//  xs intersect ys	Same as xs & ys.
//  xs | ys	The set union of xs and ys.
//  xs union ys	Same as xs | ys.
//  xs &~ ys	The set difference of xs and ys.
//  xs diff ys	Same as xs &~ ys.


}


