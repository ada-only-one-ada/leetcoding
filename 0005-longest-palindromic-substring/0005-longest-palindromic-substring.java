class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int maxLen = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j || i + 1 == j) {
                        dp[i][j] = true;
                    } else if (i + 1 < j) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } 
                } 

                if (dp[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    end = j;
                    maxLen = j - i + 1;
                } 
            }
        }

        return s.substring(start, end + 1);
    }
}