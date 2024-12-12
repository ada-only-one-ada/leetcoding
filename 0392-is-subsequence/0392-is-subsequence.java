class Solution {
    public boolean isSubsequence(String s, String t) {
        //最长公共子序列
        int[][] dp = new int[s.length()+1][t.length()+1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    dp[i][j] = dp[i][j-1]; //删掉当前一个不相等的j
                }
            }
        }

        if (dp[s.length()][t.length()] == s.length()) return true;
        return false; 
    }
}