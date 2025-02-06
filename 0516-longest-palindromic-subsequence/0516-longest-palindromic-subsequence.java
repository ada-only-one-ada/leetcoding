class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= s.length(); len++) {  // 子序列的长度从2到n
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;  // 如果两端字符相同，则在内部子序列长度基础上加2
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);  // 否则，取内部去掉一个字符后的最大值
                }
            }
        }

        return dp[0][s.length() - 1];  // 整个字符串的最长回文子序列长度
    }
}
