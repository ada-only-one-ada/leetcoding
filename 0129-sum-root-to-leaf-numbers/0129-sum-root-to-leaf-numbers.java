class Solution {
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        backtracking(root, 0);
        return totalSum;
    }

    public void backtracking(TreeNode root, int currSum) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            currSum = currSum * 10 + root.val;
            totalSum += currSum;
            return;
        }

        backtracking(root.left, currSum * 10 + root.val);
        backtracking(root.right, currSum * 10 + root.val);
    }
}