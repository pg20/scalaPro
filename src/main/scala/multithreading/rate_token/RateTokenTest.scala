package multithreading.rate_token

case class Token(name: String, value: Int)

object RateTokenTest {
  def main(args: Array[String]) : Unit = {

      val rateToken: RateToken[Int] = new RateToken[Int](10)
      val producer1: Thread = new Thread (new Runnable {
        override def run(): Unit = {
          try {
            for (i <- 1 to 10) {
              //val token: Token = Token("Pg", i)
              //println("i", i)
              rateToken.setToken(i)
              println("Value set for token " + i)
            }
          } catch {
            case e: Exception => {
              println(e.getMessage)
            }
          }
        }
      })


     val consumer1 : Thread = new Thread(new Runnable {
       override def run(): Unit = {
         for (i <- 1 to 5) {
              println(s"The token got is ${rateToken.getToken()}")
         }
     }})

    producer1.start()
    //Thread.sleep(10000);

    consumer1.start()

    producer1.join()
//    producer1.wait(100)

    consumer1.join()


  }


}
