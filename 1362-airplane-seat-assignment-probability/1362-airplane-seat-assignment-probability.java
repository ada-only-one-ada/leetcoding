class Solution {
    public double nthPersonGetsNthSeat(int n) {
        // 如果一共只有 1 个人，那这个人怎么乱选都能选对它的位置
        if (n <= 1) return 1.0;

        /* 
        如果有 n 个人，第一个人的情况：
            坐了自己的位置：1/n * 1.0，
            坐了第 n 的位置：1/n * 0.0，    
            坐了第 2 的位置：1/n * P(n-1) 
            -> 第二个人上飞机，面临同一种情况，只不过规模少了一个人 -> 坐了自己的位置，坐了第 n 的位置，坐了[3, n-1]之一。
                  3 的位置：1/n * P(n-1)
                  4 的位置：1/n * P(n-1)
                  . 
                  .
                  n-1 的位置：1/n * P(n-1)
                  共 n-2 个
        
        所以 P(n) = 1/n + (n-2)/n * P(n-1)
        让 n 等于任何数字，最后结果都是 0.5
        */

        double[] dp = new double[n + 1];
        dp[1] = 1.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = (1.0 / i) 
                  + (double) (i - 2) / i * dp[i - 1];
        }

        return dp[n];
    }
}