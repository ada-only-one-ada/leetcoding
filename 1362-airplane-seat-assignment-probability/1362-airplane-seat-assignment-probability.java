class Solution {
    public double nthPersonGetsNthSeat(int n) {
        // 如果一共只有1个人，那这个人怎么乱选都能选对它的位置
        if (n <= 1) return 1.0;

        double[] dp = new double[n + 1];
        dp[1] = 1.0;

        for (int i = 2; i <= n; i++) {
            dp[i] = (1.0 / i) 
                  + (double) (i - 2) / i * dp[i - 1];
        }

        return dp[n];
    }
}