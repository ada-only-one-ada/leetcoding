class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][5];
        /*
        不操作：dp[i][0] = dp[i-1][0]

        第一次持有：dp[i][1]
        1.之前没有，第i天买入：-prices[i-1]
        2.之前就已经第一次持有了(但还没交易过,所以还是第一次持有的状态）：dp[i-1][1]

        第一次不持有：dp[i][2] 
        1.之前有，第i天卖掉：dp[i-1][1] + prices[i-1]
        2.之前第一次不持有了：dp[i-1][2]

        第二次持有：dp[i][3] 
        1.在第一次不持有之后，第i天买入：dp[i-1][2] - prices[i-1]
        2.之前就已经第二次持有了：dp[i-1][3]

        第二次不持有：dp[i][4]
        1.在第二次持有以后，第i天卖掉：dp[i-1][3] + prices[i-1]
        2.之前就已经第二次不持有了：dp[i-1][4]
        */
        dp[1][1] = -prices[0];
        dp[1][2] = 0;
        dp[1][3] = -prices[0];
        dp[1][4] = 0;

        for (int i = 2; i <= prices.length; i++) {
            dp[i][1] = Math.max(-prices[i-1], dp[i-1][1]);
            dp[i][2] = Math.max(dp[i-1][1] + prices[i-1], dp[i-1][2]);
            dp[i][3] = Math.max(dp[i-1][2] - prices[i-1], dp[i-1][3]);
            dp[i][4] = Math.max(dp[i-1][3] + prices[i-1], dp[i-1][4]);
        }

        return dp[prices.length][4];
    }
}