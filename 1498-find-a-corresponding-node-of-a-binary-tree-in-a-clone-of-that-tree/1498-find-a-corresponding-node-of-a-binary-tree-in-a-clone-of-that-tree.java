class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return helper(original, cloned, target);
    }

    public TreeNode helper(TreeNode original, TreeNode cloned, TreeNode target) {
        if ( cloned == null) return null;

        if (cloned.val == target.val) {
            return cloned;
        }

        TreeNode left = helper(original, cloned.left, target);
        TreeNode right= helper(original, cloned.right, target);

        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}