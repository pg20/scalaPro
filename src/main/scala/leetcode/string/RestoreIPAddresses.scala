package leetcode.string
import scala.collection.mutable.ListBuffer


//https://leetcode.com/problems/restore-ip-addresses/
object RestoreIPAddresses {

    def isValid(segment: String): Boolean = {

      if (segment.length > 3)
        return false

      if (segment.equals(""))
        return false

      println("isValid" + segment)

      if (segment.charAt(0) != '0' && segment.toInt <= 255)
        return true
      if (segment.charAt(0) == '0' && segment.length == 1)
        return true
      return false

    }

    //     def update_output(s: String, idx: Int, ls: ListBuffer[String]): String = {
    //         if (isValid(segment)) {
    //             ls += segment
    //             return ls.mkString(".")
    //         }
    //         return ""

    //     }

    def backTrack(s: String, idx: Int, dots: Int, output: ListBuffer[String], ipaddress: ListBuffer[String]): Unit = {

      if (idx >= s.length) {
        return
      }


      val max_pos: Int = Math.min(idx + 3, s.length - 1)

      for (i <- (idx + 1 to max_pos)) {
        val ip: String = s.substring(idx + 1, i+1)
        if (isValid(ip)) {
          //println(ip)
          ipaddress += ip

          if (dots == 2) {
            val segment: String = s.substring(i + 1)
            if (isValid(segment)) {
              //println(" final " + segment)
              //println(" final list " + ipaddress)
              ipaddress += segment
              output ++= List(ipaddress.mkString("."))
              ipaddress -= segment
            }
          }
          else {
            backTrack(s, i, dots + 1, output, ipaddress)
            //println(" before list " + ipaddress)
            //println(" after list " + ipaddress)
          }
          ipaddress -= ip
        }
      }

    }


    def restoreIpAddresses(s: String): List[String] = {

      //iterate string for 0 to 3
      //recur()
      val n: Int = s.length()
      val output: ListBuffer[String] = new ListBuffer[String]()
      //ipaddress: List[String]
      backTrack(s, -1, 0, output, ListBuffer[String]())
      return output.toList

    }


}



