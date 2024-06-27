// https://leetcode.com/problems/move-zeroes/description/

object Solution283 {
    def moveZeroes(nums: Array[Int]): Array[Int] = {
        var lastNonZeroFoundAt = 0

        for (i <- nums.indices) {
            if (nums(i) != 0) {
                val temp = nums(lastNonZeroFoundAt)
                nums(lastNonZeroFoundAt) = nums(i)
                nums(i) = temp

                lastNonZeroFoundAt += 1
            }
        }

        nums
        
    }
}

@main def main283(): Unit =
  def test(nums: Array[Int], expected: Array[Int]) = {
    val output = Solution283.moveZeroes(nums)
    println(output.mkString(", "))
    assert(output.sameElements(expected))
  }

  test(nums = Array(0,1,0,3,12), expected = Array(1,3,12,0,0))
  test(nums = Array(0), expected = Array(0))
