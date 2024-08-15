class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return res;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        res = Math.max(res, left);
        res = Math.max(res, right);
        res = Math.max(res, left + right);

        return 1 + Math.max(left, right);
    }
}