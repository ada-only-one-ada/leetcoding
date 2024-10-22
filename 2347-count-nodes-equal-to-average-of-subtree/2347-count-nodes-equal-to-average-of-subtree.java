class Solution {
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int totalSum = root.val + left[0] + right[0];
        int totalNodes = 1 + left[1] + right[1];

        if (totalSum / totalNodes == root.val) {
            res++;
        }

        return new int[]{totalSum, totalNodes};
    }
}