class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }

        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;

                int pickLeftSum = prefixSum[end] - prefixSum[start];
                int pickLeftDp = dp[start + 1][end];

                int pickRightSum = prefixSum[end - 1] - (start > 0? prefixSum[start - 1] : 0);
                int pickRightDp = dp[start][end - 1];

                dp[start][end] = Math.max(pickLeftSum - pickLeftDp,  pickRightSum - pickRightDp);
            }
        }

        return dp[0][n - 1];
    }
}