class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n+1];
        // 构建前缀和数组
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + stones[i];
        }
        
        int[][] dp = new int[n][n];
        // 动态规划填表
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                dp[start][end] = Math.max(sum[end+1] - sum[start+1] - dp[start+1][end], 
                                          sum[end] - sum[start] - dp[start][end-1]);
            }
        }
        
        return dp[0][n-1];
    }
}
