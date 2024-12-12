class Solution {
    public int maxProfit(int[] prices) {
        // 低买高卖
        if (prices.length == 1) return 0;

        int res = Integer.MIN_VALUE;
        int min = prices[0];        

        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return res < 0 ? 0: res;
    }
}