class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // 看清楚是连续的，也就是一旦不一样了，就会归零
        int res = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}