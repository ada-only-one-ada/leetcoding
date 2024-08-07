class Solution {
    public boolean isBalanced(TreeNode root) {
        if (getHeight(root) == -1) return false;
        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (Math.abs(left - right) > 1) return -1;
        if (left == -1 || right == -1) return -1; // 任何一个不balanced就不是

        // 这里用 max 不是 min
        return Math.max(left, right) + 1;
    }
}