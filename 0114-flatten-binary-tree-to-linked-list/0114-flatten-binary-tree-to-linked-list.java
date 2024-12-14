class Solution {
    TreeNode prevNode = null;
    public void flatten(TreeNode root) {
        // Can you flatten the tree in-place (with O(1) extra space)?
        dfs(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        // 在递归之前先保存下来，确保不会因为展平左子树而丢失右子树的信息
        TreeNode rightSubtree = root.right;

        if (prevNode != null) {
            prevNode.right = root;
            prevNode.left = null;
        }
        prevNode = root;

        dfs(root.left);
        dfs(rightSubtree);
    }
}