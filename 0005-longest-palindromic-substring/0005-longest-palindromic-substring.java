class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if (i < s.length() - 1 && j > 0) {
                        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                    } 
                }

                if (dp[i][j]) {
                    if (j - i > end - start) {
                        start = i;
                        end = j;
                    } 
                }
            }
        }

        return s.substring(start, end + 1);
    }
}