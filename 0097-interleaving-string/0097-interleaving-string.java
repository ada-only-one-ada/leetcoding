class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // 如果 s1 和 s2 的总长度不等于 s3 的长度，则直接返回 false
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        // 创建一个二维布尔数组 dp，用于存储动态规划的中间结果
        // dp[i][j] 表示 s1 的前 i 个字符和 s2 的前 j 个字符是否能交错组成 s3 的前 i+j 个字符
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        
        // 初始化右下角的值为 true，假设表示两个字符串可以组成s3，之后loop验证正确性
        dp[s1.length()][s2.length()] = true; 

        // 从右下角开始反向遍历 dp 数组
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                // 检查 s1 的第 i 个字符是否等于 s3 的第 i+j 个字符，并且 dp[i+1][j] 为 true
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                
                // 检查 s2 的第 j 个字符是否等于 s3 的第 i+j 个字符，并且 dp[i][j+1] 为 true
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        
        // 返回 dp 数组的左上角值，即 s1 的全部字符和 s2 的全部字符是否能交错组成 s3 的全部字符
        return dp[0][0];
    }
}
