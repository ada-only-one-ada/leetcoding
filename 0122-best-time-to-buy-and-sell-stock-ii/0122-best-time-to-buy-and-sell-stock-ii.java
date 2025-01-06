class Solution {
    public int maxProfit(int[] prices) {
        // 低价买，高价卖
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0]; // 买
        dp[0][1] = 0; // 卖

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        
        // 这里肯定是卖掉的，手上有股票也没用
        return dp[dp.length - 1][1];
    }
}