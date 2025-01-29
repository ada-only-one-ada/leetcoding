class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] findx = dfs(root, x, 0, -1);
        int[] findy = dfs(root, y, 0, -1);

        return findx[0] == findy[0] && findx[1] != findy[1];
    }

    public int[] dfs(TreeNode root, int val, int level, int parent) {
        if (root == null) return new int[]{-1,-1};

        if (root.val == val) return new int[]{level, parent};

        int[] left = dfs(root.left, val, level + 1, root.val);
        int[] right = dfs(root.right, val, level + 1, root.val);

        if (left[0] != -1) return left;
        if (right[0] != -1) return right;

        return new int[]{-1,-1};
    }
}