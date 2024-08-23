class Solution {
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);
        return dfs(root, 0, totalNodes);
    }

    public boolean dfs(TreeNode root, int id, int totalNodes) {
        if (root == null) return true;
        if (id >= totalNodes) return false;

        return dfs(root.left, id * 2 + 1,  totalNodes) && dfs(root.right, id * 2 + 2, totalNodes);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}