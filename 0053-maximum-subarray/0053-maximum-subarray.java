class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return Integer.MIN_VALUE;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }

        return res;
    }
}