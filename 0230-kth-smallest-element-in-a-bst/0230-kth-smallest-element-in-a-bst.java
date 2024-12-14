class Solution {
    int count = 0;
    int k;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }

      
        dfs(root.right);
    }
}