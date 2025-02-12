class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0; // amount is 0 needs 0 coin.

        for (int bag = 1; bag <= amount; bag++) {
            for (int coin: coins) { 
                // 这里如果设置的值是Integer.MAX_VALUE, 必须要有: dp[bag - coin] != Integer.MAX_VALUE，不然下面的 +1 会溢出
                if (bag >= coin) {
                    // Can take the coin: dp[bag - coin] + 1. 
                    // 比如我们现在bag为8，目前拿到的coin是5，如果我们拿了5，就要找dp[3]的最少硬币 + 1（当前硬币）
                    dp[bag] = Math.min(dp[bag], dp[bag - coin] + 1);
                }

            }
        }

        return dp[amount] == amount + 1? - 1: dp[amount];
    }
}