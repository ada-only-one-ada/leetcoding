class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        } 

        if (cloned.val == target.val) {
            return cloned;
        } 

        TreeNode left = getTargetCopy(original, cloned.left, target);
        TreeNode right = getTargetCopy(original, cloned.right, target);

        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}