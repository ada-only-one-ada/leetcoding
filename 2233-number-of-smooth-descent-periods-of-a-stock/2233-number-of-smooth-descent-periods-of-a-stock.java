class Solution {
    public long getDescentPeriods(int[] prices) {
        // 递减数列by1:【4，3，2】，【3，2】，【2】

        // 【3，2，1，4】
        //  1  1  1  1
        //     1  2  

        int[] dp = new int[prices.length];
        Arrays.fill(dp, 1);

        long res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            // 当前数字可以和之前的每个字数组都组成新的递减字数组
            if (prices[i - 1] - 1 == prices[i]) {
                dp[i] += dp[i-1];
            }

            res += dp[i];
        } 

        return res;
    }
}