package multithreading.bounded_queue
import scala.reflect.ClassTag

class BlockingQueue[T](implicit m: ClassTag[T]) {


    var arr: Array[T] = _
    var size: Int = 0
    var capacity: Int = 0
    var head: Int = 0
    var tail: Int = 0

   def this(capacity: Int)(implicit m: ClassTag[T]) {
     this()
     this.arr = new Array[T](capacity)
     this.capacity = capacity
   }

   def enqueue(item: T): Unit = {
     synchronized({
          while (size == capacity)
            wait()

          if (tail == capacity) {
              tail = 0
          }

          arr(tail) = item
          size += 1
          tail += 1

         notifyAll()
     })
     
   }
  
  def dequeue(): T = {
      synchronized({

        while (size == 0) {
          wait()
        }

        if (head == capacity) {
          head = 0
        }

        val item: T = arr(head)
        head += 1
        size -= 1

        notifyAll()
        return item
      })
  }


}
