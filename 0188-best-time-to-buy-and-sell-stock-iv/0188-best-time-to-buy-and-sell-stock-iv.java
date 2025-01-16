class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k * 2];
        for (int i = 0; i < k * 2; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int currK = 0; currK < k * 2; currK++) {
                if (currK == 0) {
                    dp[i][currK] = Math.max(dp[i-1][currK], -prices[i]);
                } else {
                    if (currK % 2 == 0) {
                        dp[i][currK] = Math.max(dp[i-1][currK], dp[i-1][currK - 1] - prices[i]);
                    } else {
                        dp[i][currK] = Math.max(dp[i-1][currK], dp[i-1][currK - 1] + prices[i]);
                    }
                }
            }
        }

        return dp[prices.length - 1][k * 2 - 1];
    }
}