// https://leetcode.com/problems/can-place-flowers/description/

object Solution {
  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    var count = 0
    var canPlace = false

    for (i <- flowerbed.indices if !canPlace) {
      if (flowerbed(i) == 0) {
        val emptyLeft = (i == 0) || (flowerbed(i - 1) == 0)
        val emptyRight = (i == flowerbed.length - 1) || (flowerbed(i + 1) == 0)

        if (emptyLeft && emptyRight) {
          flowerbed(i) = 1
          count += 1

          if (count >= n) {
            canPlace = true
          }
        }
      }
    }

    count >= n
  }
}

@main def main(): Unit =
  def test(flowerbed: Array[Int], n: Int, expected: Boolean) = {
    val output = Solution.canPlaceFlowers(flowerbed, n)
    println(output)
    assert(output == expected)
  }

  test(flowerbed = Array(1, 0, 0, 0, 1), n = 1, expected = true)
  test(flowerbed = Array(1, 0, 0, 0, 1), n = 2, expected = false)
