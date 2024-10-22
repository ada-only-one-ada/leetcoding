class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);   
    }

    public int helper(TreeNode root, int min, int max) {
        if (root == null) {
            return Math.abs(max - min);
        }

        // 更新最大最小值，递归计算左右子树的最大差值
        int left = helper(root.left, Math.min(min, root.val), Math.max(max, root.val));
        int right = helper(root.right, Math.min(min, root.val), Math.max(max, root.val));
        
        return Math.max(left, right);
    }
}