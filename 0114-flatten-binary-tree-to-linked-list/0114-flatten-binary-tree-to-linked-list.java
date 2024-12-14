class Solution {
    TreeNode prevNode = null;
    public void flatten(TreeNode root) {
        // Can you flatten the tree in-place (with O(1) extra space)?
        dfs(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        TreeNode leftSubtree = root.left;
        TreeNode rightSubtree = root.right;

        if (prevNode != null) {
            prevNode.right = root;
            prevNode.left = null;

        }
        prevNode = root;

        dfs(leftSubtree);
        dfs(rightSubtree);
    }
}