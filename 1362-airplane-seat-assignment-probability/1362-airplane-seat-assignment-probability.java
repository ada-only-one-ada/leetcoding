class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if (n <= 1) return 1.0;

        double[] dp = new double[n + 1];
        dp[1] = 1.0;
        System.out.println(1.0/2);
        for (int i = 2; i <= n; i++) {
            dp[i] = (double)(1.0/i) + (double)(i-2)/(double)i * dp[i - 1];
        }

        return dp[n];
    }
}