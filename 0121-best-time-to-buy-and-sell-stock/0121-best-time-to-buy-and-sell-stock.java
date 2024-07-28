class Solution {
    public int maxProfit(int[] prices) {
        int minCost = prices[0];
        int revenue = 0;

        for (int i = 1; i < prices.length; i++) {
            revenue = Math.max(revenue, prices[i] - minCost);
            minCost = Math.min(minCost, prices[i]);
        }

        return revenue;
    }
}