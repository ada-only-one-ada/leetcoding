class Solution {
    public long maxScore(int[] a, int[] b) {
        long[][] dp = new long[b.length][4];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Long.MIN_VALUE;
            }
        }
        dp[0][0] = (long)b[0] * a[0];

        for (int i = 1; i < b.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], (long)b[i] * a[0]);
            // 之前的0没选过，当前的1只能选之前的1
            // 之前的0选过，当前的1可以选之前的1，或者之前的0 加 现在的1 重新选
            dp[i][1] = dp[i-1][0] == Long.MIN_VALUE? dp[i-1][1] : Math.max(dp[i-1][1], dp[i-1][0] + (long)b[i] * a[1]);
            dp[i][2] = dp[i-1][1] == Long.MIN_VALUE? dp[i-1][2] : Math.max(dp[i-1][2], dp[i-1][1] + (long)b[i] * a[2]);
            dp[i][3] = dp[i-1][2] == Long.MIN_VALUE? dp[i-1][3] : Math.max(dp[i-1][3], dp[i-1][2] + (long)b[i] * a[3]);
        }

        return dp[dp.length - 1][3];
    }
}