package leetcode.string
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.HashMap

object Solution {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {

    // declare map to store anagrams
    //  iterate each string
    //find count of each char
    // find

    if (strs.length == 0)
      return List[List[String]]()

    val anagMap = new HashMap[String, ListBuffer[String]]()

    for (str <- strs) {
      val cntArr = Array.fill(26)(0)
      for (ch <- str) {
        cntArr(ch - 'a') += 1
      }

      var allcharStr: String = "#"
      for (i <- 0 until 26) {
        allcharStr += (cntArr(i).toString)
      }
      if (anagMap.contains(allcharStr))
        anagMap(allcharStr) += str
      else anagMap += (allcharStr -> ListBuffer[String](str))
    }

    anagMap.map(_._2.toList).toList
  }

}
