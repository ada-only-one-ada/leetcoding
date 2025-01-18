class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, null, null);
    }

    public int helper(TreeNode root, TreeNode parent, TreeNode grandparent) {
        if (root == null) return 0;

        int subtree = helper(root.left, root, parent) + helper(root.right, root, parent);
        if (grandparent != null && grandparent.val % 2 == 0) {
            return root.val + subtree;
        } else {
            return subtree;
        }
    }
}