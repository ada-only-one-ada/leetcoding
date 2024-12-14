class Solution {
    int count = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) return;

        dfs(root.left, k);
        // 先数数
        count++;
        // 再判断
        if (count == k) {
            res = root.val;
            return;
        }

        dfs(root.right, k);
    }
}