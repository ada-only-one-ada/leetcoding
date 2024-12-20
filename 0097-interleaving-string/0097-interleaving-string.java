class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = dp[ i- 1][0];
            } else {
                dp[i][0] = false;
            }
        }
        
        for (int j = 1; j <= s2.length(); j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                char target = s3.charAt(i + j - 1);
                char lastTarget = s3.charAt(i + j - 2);

                if (c1 == target) {
                    dp[i][j] = dp[i-1][j];
                }

                if (c2 == target) {
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}