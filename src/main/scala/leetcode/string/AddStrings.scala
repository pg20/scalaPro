package leetcode.string

//https://leetcode.com/problems/add-strings/


object AddStrings {
  def addStrings(num1: String, num2: String): String = {

    var l1: Int = num1.length
    var l2: Int = num2.length

    val l3: Int = Math.min(l1, l2)

    var remainder: Int = 0

    var i = l1 - 1
    var j = l2 - 1
    var sb: StringBuilder = new StringBuilder("")

    while (i >= 0 || j >= 0) {
      //println(s" ${i} ${j}")
      val x1: Int = if (i >= 0) num1.charAt(i) - '0' else 0
      val x2: Int = if (j >= 0) num2.charAt(j) - '0' else 0
      val quotient: Int = (x1 + x2 + remainder) % 10
      remainder = (x1 + x2 + remainder) / 10
      //println(s" ${quotient} ${remainder}")

      sb ++= (quotient.toString)
      i -= 1
      j -= 1
    }
    if (remainder != 0)
      sb ++= (remainder.toString)

    return sb.toString.reverse

  }
}
