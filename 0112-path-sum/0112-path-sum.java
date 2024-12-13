class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return backtracking(root, targetSum, 0);
    }

    public boolean backtracking(TreeNode root, int targetSum, int currSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            if (currSum + root.val == targetSum) {
                return true;
            }
            return false;
        }

        return backtracking(root.left, targetSum, currSum + root.val) ||
        backtracking(root.right, targetSum, currSum + root.val);
    }
}