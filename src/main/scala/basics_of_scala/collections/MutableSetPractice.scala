package basics_of_scala.collections
import scala.collection.mutable.Set

//Just like an immutable set, a mutable set offers the + and ++ operations for element additions and the - and -- operations for element removals. But these are less often used for mutable sets since they involve copying the set.
// As a more efficient alternative, mutable sets offer the update methods += and -=. The operation s += elem adds elem to the set s as a side effect, and returns the mutated set as a result.
// Likewise, s -= elem removes elem from the set, and returns the mutated set as a result. Besides += and -= there are also the bulk operations ++= and --= which add or remove all elements of a traversable or an iterator.
//Mutable sets also provide add and remove as variants of += and -=. The difference is that add and remove return a Boolean result indicating whether the operation had an effect on the set.

//The current default implementation of a mutable set uses a hashtable to store the set’s elements. The default implementation of an immutable set uses a representation that adapts to the number of elements of the set.
// An empty set is represented by just a singleton object. Sets of sizes up to four are represented by a single object that stores all elements as fields. Beyond that size, immutable sets are implemented as hash tries.
//A consequence of these representation choices is that, for sets of small sizes (say up to 4), immutable sets are usually more compact and also more efficient than mutable sets.
// So, if you expect the size of a set to be small, try making it immutable.


//You can use
//var s1 = Set(1, 2, 3, 4, 5) used var
//val s2 = Set(1, 2, 3, 4, 5) used val
// s1 += 4  -> this one calls s1 = s1 + 4
// s2 += 4  -> this one calls the += method in mutable collection


//The end effect is very similar to the previous interaction; we start with a Set(1, 2, 3) and end up with a Set(1, 3, 4). However, even though the statements look the same as before, they do something different. s += 4 now invokes the += method on the mutable set value s, changing the set in place. Likewise, s -= 2 now invokes the -= method on the same set.

//Comparing the two interactions shows an important principle. You often can replace a mutable collection stored in a val by an immutable collection stored in a var, and vice versa. This works at least as long as there are no alias references to the collection through which one can observe whether it was updated in place or whether a new collection was created.

//REF: https://docs.scala-lang.org/overviews/collections/sets.html

object MutableSetPractice extends App {

  //create set
  var s = Set(1, 2, 3, 4, 5)


  //access set


  //add element in set
  s += (5)
  s ++= Set(6, 7, 8)
  s.foreach(print)

  //remove element in set
  s -= (5)
  s --= Set(7, 8)
  s.foreach(print)


  //extra fns



}


