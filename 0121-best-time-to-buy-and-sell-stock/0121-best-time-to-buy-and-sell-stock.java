class Solution {
    public int maxProfit(int[] prices) {
        int cost = prices[0];
        int maxSellPrice = 0;

        int revenue = 0;

        for (int i = 1; i < prices.length; i++) {
            maxSellPrice = prices[i];
            revenue = Math.max(revenue, maxSellPrice - cost);
            cost = Math.min(cost, prices[i]);
        }

        return revenue;
    }
}