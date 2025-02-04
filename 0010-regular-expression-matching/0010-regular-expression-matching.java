class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        for (int j = 1; j < pLen + 1; j++) {
            char c = p.charAt(j-1);
            if (c == '*') {
                dp[0][j] = dp[0][j-2];
            } 
        }

        for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < pLen + 1; j++) {
                char c1 = s.charAt(i-1);
                char c2 = p.charAt(j-1);

                if (c1 == c2 || c2 == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (c2 == '*') {
                    char prevChar = p.charAt(j-2);
                    if (prevChar == c1 || prevChar == '.' || prevChar == '*') {
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }

        return dp[sLen][pLen];
    }
}