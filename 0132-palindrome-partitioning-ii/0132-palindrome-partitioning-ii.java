class Solution {
    public int minCut(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(j);

                if (c1 == c2) {
                    if (i == j || i + 1 == j) {
                        isPalindrome[i][j] = true;
                    } else if (i + 1 < j) {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                } else {
                    isPalindrome[i][j] = false;
                }
            }
        }

        // dp[i] 表示 [0, i] 最小cut次数
        int[] dp = new int[s.length()];
        /* 初始化，例子 abb
        i = 0，dp[0] = 0，也就是 a 最多被cut 0 次
        i = 1，dp[1] = 1，也就是 ab 最多被cut 1 次
        i = 2，dp[2] = 2，也就是 abb 最多被cut 2次
        */
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            // 如果 [0, i] 本身就是回文串，那么最小cut次数为0，比如 aab 中的 aa
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            // 如果 [0, i] 不是回文串，我们要去 cut 它，比如 aab中的 aab
            } else {
                for (int cut = 0; cut < i; cut++) {
                    /* 
                    dp[cut] 的结果是已知的，如果 cut 的右边 到 i 即 [cut, i] 是一个回文串
                    那么就是 dp[cut] + 1
                    我们可以在不同位置 cut，选一个最小的即可
                    例子：
                      c
                    a | b b
                    dp[cut] = 0
                    因为 isPalindrom[cut + 1][i] 即 bb 是回文串
                    结果就是 dp[cut] + 1 = 0 + 1
                    */
                    
                    if (isPalindrome[cut + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[cut] + 1);
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }
}