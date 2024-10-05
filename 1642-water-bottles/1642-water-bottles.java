class Solution {
    int res = 0;
    public int numWaterBottles(int numBottles, int numExchange) {
        return helper(0, numBottles, numExchange);
    }

    public int helper(int empty, int full, int numExchange) {
        if ((empty + full) < numExchange && full < numExchange) {
            res += full;
            return res;
        }
        
        res += full;

        int exchangable = (empty + full) / numExchange;
        empty = (empty + full) % numExchange;

        helper(empty, exchangable, numExchange);

        return res;
    }
}