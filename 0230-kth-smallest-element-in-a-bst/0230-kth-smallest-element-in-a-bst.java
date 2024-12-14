class Solution {
    int count = 0;
    int k;
    int res = 0;
    boolean found = false;  // 新增一个标志位，用于指示是否已找到第k小的元素

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null || found) return;  // 如果节点为空或者已找到，直接返回

        dfs(root.left);
        count++;
        if (count == k) {
            res = root.val;
            found = true;  // 找到后将标志位设为true，后续递归调用会直接返回
            return;
        }
        dfs(root.right);
    }
}
