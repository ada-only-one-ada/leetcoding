class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = dp[1];
            dp[1] = dp[0] + dp[1];
            dp[0] = temp;
        }

        return dp[1];
    }
}