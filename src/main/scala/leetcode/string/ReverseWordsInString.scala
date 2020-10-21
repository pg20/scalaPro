package leetcode.string

object ReverseWordsInString {

  def trimSpaces(s: String): StringBuilder = {
    val s1 = s.trim
    val s2 = s1.reverse
    var s3 : StringBuilder = new StringBuilder()

    var start: Int = 0
    var end: Int = s2.length
    while (start < end) {
      val ch: Char = s2.charAt(start)
      if (ch != ' ')
        s3 += ch
      else if (s2.charAt(s3.length() - 1) != ' ')
        s3 += ch
        start += 1
    }
    s3
  }

  def reverse(s: StringBuilder, start: Int, end: Int): StringBuilder = {
    var left: Int = start
    var right: Int = end

    while (left < right) {
      val left_char: Char = s.charAt(left)
      s.setCharAt(left, s.charAt(right))
      left += 1
      s.setCharAt(right, left_char)
      right -= 1
    }
      s
  }


  def reverseWordsInString(sb: StringBuilder) = {

      val n: Int = sb.length()
      var start: Int = 0
      var end: Int = 0

      while (start < n) {

          while (end < n && sb.charAt(end) != ' ')
             end  += 1
          reverse(sb, start , end - 1)
          start = end + 1
          end += 1
      }
      sb

  }

  def main(args: Array[String]): Unit = {
    val s: String = "the sky is blue"
    val sb: StringBuilder = trimSpaces(s)
    //val sb1: StringBuilder = reverse(sb, 0, sb.length() - 1)
    println(sb)
    val sb2: StringBuilder = reverseWordsInString(sb)
    println(sb2)
  }

}
