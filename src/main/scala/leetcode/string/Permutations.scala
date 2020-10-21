package leetcode.string
import scala.collection.mutable.ListBuffer

object Permutations {

    def backtrack (output: ListBuffer[List[Int]], n: Int,nums: ListBuffer[Int], curr_idx: Int) {

      if (curr_idx == n) {
        //println("in base case", nums)
        output += (nums.toList)
        //println(output)
      }

      for (i <- curr_idx until n) {
        //swap(nums, curr_idx, i);
        //println(nums, curr_idx)

        val curr_char = nums(curr_idx)
        nums.update(curr_idx, nums(i))
        nums.update(i, curr_char)
        //println("after swap",  nums, curr_idx, i)

        backtrack(output, n, nums, curr_idx + 1);

        val curr_char1 = nums(curr_idx)
        nums.update(curr_idx, nums(i))
        nums.update(i, curr_char1)
        //println("revert back ", nums, curr_idx, i)


      }


    }

    def permute(nums: Array[Int]): List[List[Int]] = {


      var output: ListBuffer[List[Int]] = new ListBuffer[List[Int]]()
      if (nums.length == 0)
        return List[List[Int]]()

      val num_list: ListBuffer[Int] =  new ListBuffer()
      val n: Int = nums.length
      for (num <- nums) {
        num_list += num
      }

      //val num_list =  nums.toList
      backtrack(output, n, num_list, 0)
      return output.map(_.toList).toList

    }
}

