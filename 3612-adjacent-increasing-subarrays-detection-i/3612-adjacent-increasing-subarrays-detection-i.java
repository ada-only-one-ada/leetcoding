class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (i - k + 1 >= 0 && i + k <= dp.length - 1) {
                if (dp[i] - dp[i-k+1] + 1 == k && dp[i+k] - dp[i+1] + 1 == k) {
                    return true;
                }
            }
        }

        return false;
    }
}