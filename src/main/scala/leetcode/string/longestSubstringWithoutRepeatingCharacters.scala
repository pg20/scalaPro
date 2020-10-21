package leetcode.string
import scala.collection.mutable.HashSet

object lengthOfLongestSubstring {

    def lengthOfLongestSubstring(s: String): Int = {

      val n: Int = s.length;
      var curr_window_chars = new HashSet[Char]()
      var start: Int = 0
      var end: Int = 0
      var ans: Int = 0

      while (start <= end && end < s.length) {
        if (!curr_window_chars.contains(s(end))) {
          curr_window_chars.add(s(end))
          end = end + 1
          ans = Math.max(ans, end - start)
        } else {
          curr_window_chars.remove(s(start))
          start += 1
        }
        //println("ans = ", ans)

      }
      return ans
    }
}
