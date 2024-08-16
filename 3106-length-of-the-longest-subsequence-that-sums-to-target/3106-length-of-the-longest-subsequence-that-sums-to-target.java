class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        if (nums.size() == 0) return -1;

        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int num: nums) {
            for (int currTarget = target; currTarget >= num; currTarget--) {        
                if (dp[currTarget - num] != -1) {
                    dp[currTarget] = Math.max(dp[currTarget], dp[currTarget - num] + 1);
                }
            }
        }

        return dp[target];
    }
}