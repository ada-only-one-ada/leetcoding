class Solution {
    int val = -1;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (val == -1) {
            val = root.val;
        } else {
            if (root.val != val) return false;
        }

        return isUnivalTree(root.left) &&
        isUnivalTree(root.right);
    }
}