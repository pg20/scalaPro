package multithreading.bounded_queue

object ProducerConsumerTest {


  def main(args: Array[String]) = {
      val blockingQueue: BlockingQueue[Integer] = new BlockingQueue[Integer](100)
      val thread1: Thread  = new Thread(new Runnable {
          override def run(): Unit =
          {
            try {
              for (i <- 1 to 100) {
                blockingQueue.enqueue(i)
                println(s"Enqueued value $i")
              }

            } catch {
              case e: Exception => {
                println(e.getMessage)
              }
            }
          }
      })

    val thread2: Thread = new Thread(new Runnable {
          override def run(): Unit = {
              for (i <- 1 to 50) {
                 println("Thread 2 dequeued " + blockingQueue.dequeue())
              }
         }
    })

    val thread3: Thread = new Thread (new Runnable {
      override def run() : Unit = {
        for (i <- 1 to 50) {
          println("Thread 3 dequeued " + blockingQueue.dequeue())
        }
      }
    })

    thread1.start()
    Thread.sleep(4000);

    thread2.start()

    thread3.start()
    thread2.join()
    thread1.join()
    thread3.join()


  }


}
