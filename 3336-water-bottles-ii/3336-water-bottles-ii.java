class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        // 最多换一个

        return helper(numBottles, 0, numExchange, 0);
    }

    public int helper(int full, int empty, int numExchange, int totalDrank) {
        if (full + empty < numExchange) {
            return full + totalDrank;
        }

        int needFull = numExchange - empty; // 还需要喝掉这么多
        int newFull = full - needFull + 1; // 喝完这么多，然后和之前的空瓶一起换了一瓶full的

        int newEmpty = (empty + needFull) - numExchange; // 新空瓶等于全部空瓶，去掉exchange的

        return helper(newFull, newEmpty, numExchange + 1, totalDrank + needFull);  
    }
}
