class Solution {
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        helper(root);
        return sum;
    }

    public void helper(TreeNode root) {
        if (root == null) return;

        if (root.val % 2 == 0) {
            if (root.left != null && root.left.left != null) sum += root.left.left.val;
            if (root.left != null && root.left.right != null) sum += root.left.right.val;
            if (root.right != null && root.right.left != null) sum += root.right.left.val;
            if (root.right != null && root.right.right != null) sum += root.right.right.val;
        } 

        helper(root.left);
        helper(root.right);
    }
}