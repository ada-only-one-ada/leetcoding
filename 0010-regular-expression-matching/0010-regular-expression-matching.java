class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j-1) == '*') {
                // ...*a,那么*前一个肯定可以被*吸收，关键看再前面的一个
                dp[0][j] = dp[0][j-2];
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                char c1 = s.charAt(i-1);
                char c2 = p.charAt(j-1);

                if (c1 == c2 || c2 == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (c2 == '*') {
                    char prevChar = p.charAt(j-2);
                    // preChar匹配s当前字符，可选择匹配多次（dp[i-1][j]）或零次（dp[i][j-2]）
                    if (prevChar == c1 || prevChar == '.') {
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    // preChar不匹配，只能选择匹配零次，即跳过preChar和*
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}