class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        
        int maxSum = nums[0];
        dp[0] = nums[0]; 
        
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}