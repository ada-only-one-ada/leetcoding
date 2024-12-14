class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        if (prev != null)  {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        dfs(root.right);
    }
}