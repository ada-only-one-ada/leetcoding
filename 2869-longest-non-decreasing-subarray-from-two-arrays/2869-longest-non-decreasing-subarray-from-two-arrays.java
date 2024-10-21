class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        if (n == 0) return 0;

        // dp[i][0]: 以 nums1 的 i 结尾的max length
        // dp[i][1]: 以 nums2 的 i 结尾的max length
        int[][] dp = new int[n][2];
        // 初始化每个数字就是长度1
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            // 当前数字大于或等于自己的array的上一个数字，长度+1
            if (nums1[i] >= nums1[i - 1]) dp[i][0] = dp[i - 1][0] + 1; 
            if (nums2[i] >= nums2[i - 1]) dp[i][1] = dp[i - 1][1] + 1;

            // 不仅比自己的前一个数字大，也比对方的大，我们把当前结果接到长的串上
            if (nums1[i] >= nums2[i - 1]) dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
            if (nums2[i] >= nums1[i - 1]) dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
            maxLen = Math.max(Math.max(dp[i][0], dp[i][1]), maxLen);
        }

        return maxLen;
    }
}

// 当前num1比之前num1结尾的数大，能够在前面的结果 + 1
// 当前num1也比之前num2结尾的数大，当前res我们更新到最大的，即把当前num1串到较长的结果中
// 当前num2比之前num2结尾的数大，能够在前面结果+1
//当前num2也比之前num1结尾的数大，当前res我们更新到最大的，即把当前num2串到较长的结果中

