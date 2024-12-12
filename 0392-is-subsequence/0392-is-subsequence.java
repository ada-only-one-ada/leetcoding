class Solution {
    public boolean isSubsequence(String s, String t) {
    int[] dp = new int[t.length() + 1];

    for (int i = 1; i <= s.length(); i++) {
        int prev = 0; // dp[i-1][j-1]
        for (int j = 1; j <= t.length(); j++) {
            int temp = dp[j]; // 暂存当前 dp[j]
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                dp[j] = prev + 1;
            } else {
                dp[j] = dp[j - 1];
            }
            prev = temp; // 更新 prev
        }
    }

    return dp[t.length()] == s.length();
}

}