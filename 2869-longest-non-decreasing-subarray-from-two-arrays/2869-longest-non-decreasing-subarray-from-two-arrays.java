class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        int res = 1;

        for (int i = 1; i < n; i++) {
            if (nums1[i] >= nums1[i - 1]) {
                dp[i][0] = dp[i - 1][0] + 1;
            }

            if (nums1[i] >= nums2[i - 1]) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
            }

            if (nums2[i] >= nums2[i - 1]) {
                dp[i][1] = dp[i - 1][1] + 1;
            }

            if (nums2[i] >= nums1[i - 1]) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
            }

            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }

        return res;
    }
}