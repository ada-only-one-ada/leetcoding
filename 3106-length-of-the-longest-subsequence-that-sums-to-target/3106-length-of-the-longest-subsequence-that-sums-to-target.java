class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        if (nums.size() == 0) return -1;

        int[][] dp = new int[nums.size() + 1][target + 1];
        // 前0个元素，不可能有等于target和的序列
        Arrays.fill(dp[0], -1);
        // 除非target和就等于0
        dp[0][0] = 0;

        for (int i = 1; i <= nums.size(); i++) {
            for (int currTarget = 0; currTarget <= target; currTarget++) {
                // 当前元素
                int num = nums.get(i - 1);
        
                // 1. 不拿当前元素
                dp[i][currTarget] = dp[i - 1][currTarget];
                // 2. 拿当前元素 (满足条件时), 也有可能不是最长的，所以要考虑不拿的时候最长
                if (currTarget >= num && dp[i - 1][currTarget - num] != -1) {
                    dp[i][currTarget] = Math.max(dp[i][currTarget], dp[i - 1][currTarget - num] + 1);
                }
            }
        }

        return dp[nums.size()][target];
    }
}