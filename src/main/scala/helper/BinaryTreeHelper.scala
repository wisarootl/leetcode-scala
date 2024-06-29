package binarytreehelper

class TreeNode(
    var value: Int = 0,
    var left: TreeNode = null,
    var right: TreeNode = null
) {

  override def toString: String = arrayRepresentation().mkString("[", ", ", "]")

  override def equals(other: Any): Boolean = other match {
    case that: TreeNode =>
      (that.canEqual(this)) &&
      value == that.value &&
      left == that.left &&
      right == that.right
    case _ => false
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[TreeNode]

  def maxDepth: Int = {
    def _maxDepth(node: TreeNode): Int = {
      if (node == null) return 0
      val leftDepth = _maxDepth(node.left)
      val rightDepth = _maxDepth(node.right)
      Math.max(leftDepth, rightDepth) + 1
    }

    _maxDepth(this)
  }

  def arrayRepresentation(): List[Option[Int]] = {
    val maxDepth = this.maxDepth
    var nodes: List[TreeNode] = List(this)
    var result: List[Option[Int]] = List()

    for (_ <- 1 to maxDepth) {
      var levelNodes: List[TreeNode] = List()
      var levelValues: List[Option[Int]] = List()

      for (node <- nodes) {
        if (node != null) {
          levelValues = levelValues :+ Some(node.value)
          levelNodes = levelNodes :+ node.left :+ node.right
        } else {
          levelValues = levelValues :+ None
          levelNodes = levelNodes :+ null :+ null
        }
      }
      result = result ++ levelValues
      nodes = levelNodes
    }

    result = result.reverse.dropWhile(_.isEmpty).reverse
    result
  }
}

def buildBinaryTreeFromArrayRepresentation(nodeValues: List[Option[Int]]): TreeNode = {
if (nodeValues.isEmpty) return null

val nodes = nodeValues.map {
    case Some(value) => new TreeNode(value)
    case None => null
}

for (i <- nodes.indices) {
    val node = nodes(i)
    if (node != null) {
    val leftChildIdx = 2 * i + 1
    val rightChildIdx = 2 * i + 2

    if (leftChildIdx < nodes.size) {
        node.left = nodes(leftChildIdx)
    }
    if (rightChildIdx < nodes.size) {
        node.right = nodes(rightChildIdx)
    }
    }
}

nodes.head
}