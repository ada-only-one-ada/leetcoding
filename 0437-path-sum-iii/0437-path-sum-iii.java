class Solution {
    // 在遍历树的过程中，从根节点到当前节点的所有节点值的累计和，以及出现的频率
    Map<Long, Integer> freq = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        freq.put(0L, 1); // 和为0的路径有1个，为了方便处理从根节点开始且直接等于targetSum的情况
        return backtracking(root, targetSum, 0L);
    }

    public int backtracking(TreeNode root, int targetSum, long prefixSum) {
        if (root == null) return 0;

        /* 
        nums = [10, 5, 3, 3]
        prefixSum = [10, 15, 18, 21]
        假设我们现在遍历到18，那么我们要找prefixSum(18) - target(8), 即10有多少个
        */
        prefixSum += root.val;
        int prePaths = freq.getOrDefault(prefixSum - targetSum, 0);
     
        freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);
        int res = prePaths + 
                  backtracking(root.left, targetSum, prefixSum) +
                  backtracking(root.right, targetSum, prefixSum);
        freq.put(prefixSum, freq.get(prefixSum) - 1);

        return res;
    }
}