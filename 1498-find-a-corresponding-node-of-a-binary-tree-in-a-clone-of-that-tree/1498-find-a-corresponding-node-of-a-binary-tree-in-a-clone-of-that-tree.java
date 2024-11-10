class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned != null && cloned.val == target.val) {
            return cloned;
        } 

        if (cloned == null) {
            return null;
        } 

        TreeNode res1 = getTargetCopy(original, cloned.left, target);
        TreeNode res2 = getTargetCopy(original, cloned.right, target);

        if (res1 != null) return res1;
        if (res2 != null) return res2;
        return null;
    }
}