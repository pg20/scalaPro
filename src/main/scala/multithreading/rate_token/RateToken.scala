package multithreading.rate_token

import scala.reflect.ClassTag



class RateToken[T] {

  var size: Int = _
  var bucket: Array[T] = _
  var capacity: Int = _

  def this(capacity: Int)(implicit m: ClassTag[T]) {
    this()
    bucket = new Array[T](capacity)
    this.capacity = capacity
    this.size = 0
  }

  def getToken(): T = {
      synchronized({
            if (size == 0) {
              println(s"waiting in getToken ${size}")
              wait()
            }

            val item: T =  bucket(size - 1)
            size -= 1
            println(s"Value got for token  ${item} for index $size")


            notifyAll()
            item
      })
  }

  def setToken(item: T): Unit = {
      synchronized({
            if (capacity == size) {
                 println(s"waiting in setToken ${size}")
                 wait()
            }
            //println(s"Value set for token  ${item}")

            bucket(size) = item
            size += 1
            println(s"item set and buckt size is ${size}")

            notifyAll()
      })
  }

}
