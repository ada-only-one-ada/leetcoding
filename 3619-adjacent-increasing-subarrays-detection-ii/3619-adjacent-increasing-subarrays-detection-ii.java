class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                dp[i] = dp[i - 1] + 1;
            }
        } 

        int maxK = 1;
        for (int i = 0; i < nums.size(); i++) {
            int currK = maxK;
            while (i - currK + 1 >= 0 && i + currK <= dp.length - 1) {
                if (dp[i] - dp[i-currK+1] + 1 == currK && dp[i+currK] - dp[i+1] + 1 == currK) {
                    maxK = Math.max(maxK, currK);
                    currK++;
                } else {
                    break;
                }
            }
        }

        return maxK;
    }
}