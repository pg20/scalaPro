package coursera.course1.week1.recfun

//https://www.coursera.org/learn/progfun1/programming/
object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
        if (r < 0 || c < 0) 0
        else if (r == 0 && c == 0) 1
        else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balanceHelper(chars: List[Char], cnt: Int): Boolean = chars match {
        case Nil          => (cnt == 0)
        case '(' :: tail  => balanceHelper(tail, cnt + 1)
        case ')' :: tail  => (cnt > 0) && balanceHelper(tail, cnt - 1)
        case _ :: tail => balanceHelper(tail, cnt)
      }
      balanceHelper(chars, 0)
    }

  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = coins.foldLeft(0)((accum, cn) =>
      (money, cn) match  {
        case (money, _) if money < 0 => 0
        case (0, _) => {
          1
        }
        case (curr_money, curr_coin) => {
          val (before_curr_coin, after_curr_coin) = coins.span(_ != curr_coin)
          accum + countChange(curr_money - curr_coin, after_curr_coin)
        }
    })
    //other better solution is
//    def countChange(money: Int, coins: List[Int]): Int = {
//      if(money == 0)
//        1
//      else if(money > 0 && !coins.isEmpty)
//        countChange(money - coins.head, coins) + countChange(money, coins.tail)
//      else
//        0
//    }

  }
