class Solution {
    public int minSteps(int n) {
        if (n < 2) return 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 2; 
        
        // 偶数个A：粘一半之后，copy那一半，再粘一次即可
        // 奇数个A：9 = 3+3+3
        // 27个A：27是9粘两次，9是3粘两次
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 2;
                continue;
            }

            for (int d = i - 1; d >= 2; d--) {
                // 比如 i 是 27，d 是 9
                if (i % d == 0) {
                    // dp[9](得到9个A需要的步骤) + 1(复制9个A) + 2(粘2次9个A，9 9 9 其中第一个9已经存在)
                    dp[i] = dp[d] + 1 + (i / d - 1);    
                    break;
                } 
            }

            // 不能由其他的As paste 得来，只能一个个粘
            if (dp[i] == Integer.MAX_VALUE) dp[i] = i;
        }

        return dp[n];
    }
}