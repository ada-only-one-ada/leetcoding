/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int  widthOfBinaryTree(TreeNode root) {
  if (root == null) return 0;

  int res = 0;
  Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
  queue.add(new Pair(root, 1));

  while (!queue.isEmpty()) {
    int size = queue.size();
    int leftMost = -1;
    int rightMost = -1;

    for (int i = 0; i < size; i++) {
      Pair<TreeNode, Integer> pair = queue.poll();
      TreeNode node = pair.getKey();
      int id = pair.getValue();

      if (i == 0) leftMost = id;
      if (i == size - 1) rightMost = id;

      if (node.left != null) {
        queue.add(new Pair(node.left, id * 2));
      }

      if (node.right != null) {
        queue.add(new Pair(node.right, id * 2 + 1));
      }
    }

    res = Math.max(res, rightMost - leftMost + 1);
  }

  return res;
}
}

