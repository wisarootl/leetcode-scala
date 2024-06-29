// https://leetcode.com/problems/search-in-a-binary-search-tree/description/

import binarytreehelper.TreeNode
import binarytreehelper.buildBinaryTreeFromArrayRepresentation

object Solution700 {
  def searchBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null || root.value == `val`) {
      return root
    }

    if (`val` < root.value) {
      return searchBST(root.left, `val`)
    } else {
      return searchBST(root.right, `val`)
    }
  }
}

@main def main700(): Unit = {

  def test(
      rootValues: List[Option[Int]],
      `val`: Int,
      expectedValues: List[Option[Int]]
  ) = {
    val root = buildBinaryTreeFromArrayRepresentation(rootValues)
    val expected = buildBinaryTreeFromArrayRepresentation(expectedValues)
    val output = Solution700.searchBST(root, `val`)
    println(output)
    assert(output == expected)
  }

  test(
    rootValues =
      List(Some(4), Some(2), Some(7), Some(1), Some(3)),
    `val` = 2,
    expectedValues = List(Some(2), Some(1), Some(3))
  )

  test(
    rootValues =
      List(Some(4), Some(2), Some(7), Some(1), Some(3)),
    `val` = 5,
    expectedValues = List()
  )
  
  test(
    rootValues =
      List(Some(4), Some(2), Some(7), Some(1), Some(3), None, Some(8)),
    `val` = 8,
    expectedValues = List(Some(8))
  )
}
