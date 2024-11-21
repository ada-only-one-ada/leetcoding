class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int currentSum) {
        if (node == null) return 0;
        
        // 更新当前路径的值（将前一个值乘以2，再加上当前节点的值）
        // 当前的（最后）总是2的0次方
        // 前一个比当前多了一个2的次方
        currentSum = currentSum * 2 + node.val;

        // 如果是叶子节点，直接返回当前路径累积的值
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // 递归计算左右子树的路径和，并返回总和
        return helper(node.left, currentSum) + helper(node.right, currentSum);
    }
}
