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
    List<String> list = new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        helper(root, "");
      
        int sum = 0;
        for (String s: list) {
            sum += binaryToDecimal(s);
        }

        return sum;
    }

    public void helper(TreeNode root, String s) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            list.add(s + String.valueOf(root.val));
            return;
        }
        
        helper(root.left, s + String.valueOf(root.val));
        helper(root.right, s + String.valueOf(root.val));
    }

    public int binaryToDecimal(String s) {
        int res = 0;
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                res += (int) Math.pow(2, count);
            }
            count++;
        } 

        return res;
    }
}