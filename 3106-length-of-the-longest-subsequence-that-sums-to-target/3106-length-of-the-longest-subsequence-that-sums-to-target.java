class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        if (nums.size() == 0) return -1;

        int[] dp = new int[target + 1];
        // Initial fill with -1, indicating unreachable states
        Arrays.fill(dp, -1);
        // Base case: a sum of 0 is achievable with 0 elements
        dp[0] = 0;

        for (int num: nums) {
            // Reverse to avoid reuse in the same item iteration
            for (int currTarget = target; currTarget >= num; currTarget--) {    
                // Check if the (currTarget - num) is achievable    
                if (dp[currTarget - num] != -1) {
                    dp[currTarget] = Math.max(dp[currTarget], dp[currTarget - num] + 1);
                }
            }
        }

        return dp[target];
    }
}