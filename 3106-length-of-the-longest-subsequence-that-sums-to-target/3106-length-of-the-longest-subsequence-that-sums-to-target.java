class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        if (nums.size() == 0) return -1;

        int[][] dp = new int[nums.size() + 1][target + 1];
        Arrays.fill(dp[0], -1);
        dp[0][0] = 0;

        for (int i = 1; i <= nums.size(); i++) {
            for (int currTarget = 0; currTarget <= target; currTarget++) {
                int num = nums.get(i - 1);
                dp[i][currTarget] = dp[i - 1][currTarget];

                if (currTarget >= num && dp[i - 1][currTarget - num] != -1) {
                    dp[i][currTarget] = Math.max(dp[i - 1][currTarget], dp[i - 1][currTarget - num] + 1);
                }
            }
        }

        return dp[nums.size()][target];
    }
}