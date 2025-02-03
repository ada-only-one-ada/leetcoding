class Solution {
    int minTime = 0;     // 记录感染整棵树的最短用时
    int startDepth = -1; // 起始节点的深度（根节点深度为0）

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, 0, start);
        return minTime;
    }
    
    // 递归计算子树深度并更新最短时间
    public int dfs(TreeNode node, int currentDepth, int start) {
        if (node == null) {
            return 0;
        }
        
        // 检查当前节点是否为起始节点，并记录其深度
        if (node.val == start) {
            startDepth = currentDepth;
        }
        
        // 递归计算左右子树的最大深度
        int leftDepth = dfs(node.left, currentDepth + 1, start);
        boolean startInLeft = (startDepth != -1); // 判断起始节点是否在左子树中
        int rightDepth = dfs(node.right, currentDepth + 1, start);
        
        // 情况1：当前节点是起始节点，感染时间为左右子树的最大深度
        if (node.val == start) {
            minTime = Math.max(leftDepth, rightDepth);
        }
        
        // 情况2：当前节点是起始节点的祖先，计算经过当前节点的感染时间
        // 起始节点在左子树中：当前节点到起始节点的距离 + 右子树深度
        // 起始节点在右子树中：当前节点到起始节点的距离 + 左子树深度
        if (startInLeft) {
            minTime = Math.max(minTime, (startDepth - currentDepth) + rightDepth);
        } else {
            minTime = Math.max(minTime, (startDepth - currentDepth) + leftDepth);
        }
        
        // 返回当前节点的子树最大深度
        return Math.max(leftDepth, rightDepth) + 1;
    }
}