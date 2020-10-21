package multithreading.raceCondition

import java.util._

//1st thread: one fn is reading variable and printing
//2nd thread: one fn is updating the variable

object Demonstration {
  @throws[InterruptedException]
  def main(args: Array[String]): Unit = {
    RaceCondition.runTest()
  }
}

object RaceCondition {
  @throws[InterruptedException]
  def runTest(): Unit = {
    val rc = new RaceCondition
    val thread1 = new Thread(new Runnable {
      override def run(): Unit = {
        rc.printer()
      }
    })
    val thread2 = new Thread(new Runnable {
      override def run(): Unit = {
        rc.modifier()
      }
    })
    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()
  }
}

class RaceCondition {
  var randInt = 0
  val random = new Random(System.currentTimeMillis)

  def printer(): Unit = {
    var i = 1000000
    while ( {
      i != 0
    }) {
      if (randInt % 5 == 0) if (randInt % 5 != 0) System.out.println(randInt)
      i -= 1
    }
  }

  def modifier(): Unit = {
    var i = 1000000
    while ( {
      i != 0
    }) {
      randInt = random.nextInt(1000)
      i -= 1
    }
  }
}
