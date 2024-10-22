class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            if (root.val < limit) {
                return null;
            } else {
                return root;
            }
        }

        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);

        if (root.left == null && root.right == null) {
            return null;
        } else {
            return root;
        }
    }
}