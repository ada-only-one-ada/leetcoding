class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return helper(numBottles, 0, numExchange, 0);
    }

    public int helper(int full, int empty, int numExchange, int totalDrank) {
        if (full + empty < numExchange) {
            return full + totalDrank;
        }

        int newFull = (full + empty) / numExchange;
        int newEmpty = (full + empty) % numExchange;

        return helper(newFull, newEmpty, numExchange, totalDrank + full);
    }
}