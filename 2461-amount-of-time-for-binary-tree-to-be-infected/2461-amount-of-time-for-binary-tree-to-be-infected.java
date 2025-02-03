class Solution {
    int startDepth = -1;
    int res = 0;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start, 0);
        return res;
    }

    public int dfs(TreeNode root, int start, int depth) {
        if (root == null) {
            return 0;
        }

        if (root.val == start) {
            startDepth = depth;
        }

        int leftDepth = dfs(root.left, start, depth + 1);
        boolean startInLeft = (startDepth != -1);
        int rightDepth = dfs(root.right, start, depth + 1);

        if (root.val == start) {
            res = Math.max(leftDepth, rightDepth);
        }

        if (startInLeft) {
            res = Math.max(res, startDepth - depth + rightDepth);
        } else {
            res = Math.max(res, startDepth - depth + leftDepth);
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}