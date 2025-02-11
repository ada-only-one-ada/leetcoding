class Solution {
    TreeNode prev = null;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) return;


        helper(root.left);

        if (prev != null) {
            res = Math.min(res, root.val - prev.val);
        }
        prev = root;
        helper(root.right);

    }
}