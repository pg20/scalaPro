package multithreading.sum_of_numbers
//
//class SumUpExample {
//
//}

object Demonstration {
  @throws[InterruptedException]
  def main(args: Array[String]): Unit = {
    val sumUpExample: SumUpExample = new SumUpExample(0L, 10L)
    sumUpExample.runTest()
  }
}

class SumUpExample2(var rng1: Long, var rng2: Long) {

    def oneThread(): Unit = {
      val start = System.currentTimeMillis()
      //val sumUpExample: SumUpExample = new SumUpExample2(1, 10)
      //sumUpExample.add()
      val end = System.currentTimeMillis()
    }

    def twoThreads(): Unit  = {
      val MAX_NUM: Long = Integer.MAX_VALUE

      val start = System.currentTimeMillis
      val range: Long = MAX_NUM / 2
      val s1 = new SumUpExample(1L, range)
      val s2 = new SumUpExample(1L + range, MAX_NUM)
      val t1 = new Thread(() => {
        def foo() = s1.add()
        foo()
      })

      val t2 = new Thread(() => {
        def abc() = s1.add()
        abc()
      })
      t1.start()
      t2.start()
      t1.join()
      t2.join()
      val finalCount = s1.counter + s2.counter
      val end = System.currentTimeMillis
      System.out.println("Two threads final count = " + finalCount + " took " + (end - start))
    }

}

class SumUpExample(var startRange: Long, var endRange: Long) {
  val MAX_NUM: Long = Integer.MAX_VALUE

  @throws[InterruptedException]
  def twoThreads(): Unit = {
    val start = System.currentTimeMillis
    val range: Long = MAX_NUM / 2
    val s1 = new SumUpExample(1L, range)
    val s2 = new SumUpExample(1L + range, MAX_NUM)
    val t1 = new Thread(() => {
      def foo() = s1.add()

      foo()
    })
    val t2 = new Thread(() => {
      def abc() = s2.add()

      abc()
    })
    t1.start()
    t2.start()
    t1.join()
    t2.join()
    val finalCount = s1.counter + s2.counter
    val end = System.currentTimeMillis
    System.out.println("Two threads final count = " + finalCount + " took " + (end - start))
  }

  def oneThread(): Unit = {
    val start = System.currentTimeMillis
    val s = new SumUpExample(1L, MAX_NUM)
    s.add()
    val end = System.currentTimeMillis
    System.out.println("Single thread final count = " + s.counter + " took " + (end - start))
  }

  @throws[InterruptedException]
  def runTest(): Unit = {
    oneThread()
    twoThreads()
  }

  var counter: Long = 0L

  def add(): Unit = {
    for (i <- startRange to endRange) {
      counter += i
    }
  }
}
