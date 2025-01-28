class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int res = Integer.MIN_VALUE;

        // buy low sell high
        int low = prices[0];

        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - low);
            low = Math.min(low, prices[i]);
        }

        if (res < 0) {
            return 0;
        }
        return res;
    }
}