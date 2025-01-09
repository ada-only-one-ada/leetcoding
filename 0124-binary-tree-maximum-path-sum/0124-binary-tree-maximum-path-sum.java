class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getSum(root);
        return res;
    }

    public int getSum(TreeNode root) {
        if (root == null) return 0;

        int currVal = root.val;
        int leftSum = Math.max(getSum(root.left), 0);
        int rightSum = Math.max(getSum(root.right), 0);

        res = Math.max(res, currVal + leftSum + rightSum);
        return currVal + Math.max(leftSum, rightSum); 
    }
}