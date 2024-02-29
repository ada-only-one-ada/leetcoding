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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
       
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currRoot = queue.poll();
                currRes.add(currRoot.val);

                if (currRoot.left != null) queue.add(currRoot.left);
                if (currRoot.right != null) queue.add(currRoot.right);
            }

            res.add(0, currRes);
        }

        return res;
    }
}