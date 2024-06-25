// https://leetcode.com/problems/find-the-highest-altitude/description/
object Solution1732 {
    def largestAltitude(gain: Array[Int]): Int = {
        var currentAltitude = 0
        var highestAltitude = 0
        
        for (g <- gain) {
            currentAltitude += g
            if (currentAltitude > highestAltitude) {
                highestAltitude = currentAltitude
            }
        }
        
        highestAltitude
    }
}

@main def main1732(): Unit =
  def test(gain: Array[Int], expected: Int) = {
    val output = Solution1732.largestAltitude(gain)
    println(output)
    assert(output == expected)
  }

  test(gain = Array(-5,1,5,0,-7), expected = 1)
  test(gain = Array(-4,-3,-2,-1,4,3,2), expected = 0)
