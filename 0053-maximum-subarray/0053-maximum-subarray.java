class Solution {
    public int maxSubArray(int[] nums) {
        /* dp[i]: 以nums[i]为结尾的maximum subarray
           情况1: 延续前面的和，加上当前num，dp[i] = dp[i-1] + num
           情况2: 前面的和都不要了，从当前num开始计算，dp[i] = num
        */ 

        int[] dp = new int[nums.length + 1];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}