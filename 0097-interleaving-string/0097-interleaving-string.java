class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // 长度都不一样，直接返回
        if (s1.length() + s2.length() != s3.length()) return false;

        // dp[i][j]：s1的前i个字符 和 s2的前j个字符，能不能构成s3的前i+j个字符
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        // s1的前0个字符 和 s2的前0个字符，能构成s3的前0个字符（大家都是空字符串）
        dp[0][0] = true;

        // base case：当s1是空串，判断 s2的前j个 能不能构成 s3的前j个
        for (int j = 1; j <= s2.length(); j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                // 必须连续相等
                dp[0][j] = dp[0][j - 1];
            } 
        }

        // base case：当s2是空串，判断 s1的前i个 能不能构成 s3的前i个
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
            } 
        }

        // 遍历其他的
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char target = s3.charAt(i + j - 1);

                // 可以选s1的当前字符，选的是s1的当前字符，那么s1的上一个字符也必须被选（不能跳过）
                if (c1 == target) {
                    dp[i][j] = dp[i-1][j];
                }

                // 可以选s2的当前字符，选的是s2的当前字符，那么s2的上一个字符也必须被选（不能跳过）
                if (c2 == target) {
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}