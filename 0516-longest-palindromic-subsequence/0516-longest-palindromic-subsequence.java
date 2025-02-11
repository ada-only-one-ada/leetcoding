class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) return 0;

        int res = 1;
        int[][] dp = new int[s.length()][s.length()]; // s.substring [i,j] 
        
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i + 1 < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 2;
                res = Math.max(res, dp[i][i+1]);
            }
        }

        for (int len = 2; len <= s.length(); len++) {
            for (int left = 0; left <= s.length() - len; left++) {
                int right = left + len - 1;

                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = dp[left+1][right-1] + 2;
                } else {
                    dp[left][right] = Math.max(dp[left+1][right], dp[left][right-1]);
                }
                res = Math.max(res, dp[left][right]);
            }
        }

        return res;
    }
}