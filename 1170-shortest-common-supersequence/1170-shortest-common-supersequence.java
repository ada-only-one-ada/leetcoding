class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        // str1和str2的最长公共子序列的长度是多少（int）
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // str1和str2的最长公共子序列的长度是什么（string）
        StringBuilder commonSequence = new StringBuilder();

        // 非公共子序列的部分
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int i1 = str1.length();
        int i2 = str2.length();
        while (i1 > 0 && i2 > 0) {
            // 如果两个字符一样，说明该字符是lcs的一部分
            if (str1.charAt(i1-1) == str2.charAt(i2-1)) {
                // 将其加入res中，并同时移动i1和i2
                commonSequence.append(str1.charAt(i1-1));
                i1--;
                i2--;
            // 如果两个字符不一样，回退到更大的dp值方向
            // 这表示在不包含当前字符的情况下lcs的长度较大
            } else if (dp[i1-1][i2] >= dp[i1][i2-1]) { 
                sb1.append(str1.charAt(i1-1));
                i1--;
            } else if (dp[i1][i2-1] > dp[i1-1][i2]) {    
                sb2.append(str2.charAt(i2-1));
                i2--;
            }
        }

        while (i1 > 0) {
            sb1.append(str1.charAt(i1-1));
            i1--;
        }

        while (i2 > 0) {
            sb2.append(str2.charAt(i2-1));
            i2--;
        }

        // 倒序（因为是从后往前构建的）
        String lcs = commonSequence.reverse().toString();

        // 根据lcs和原字符串构建最短公共超序列
        // 这段代码的核心是在构建scs时不仅添加lcs中的字符，而且要添加在达到下一个lcs字符之前的 str1 和 str2 中的所有字符。
        // 这确保了任何一个输入字符串的所有字符都被保留在结果中，并且结果字符串尽可能短。
        StringBuilder res = new StringBuilder();

        i1 = 0;
        i2 = 0;
        for (char c : lcs.toCharArray()) {
            // 跳过lcs中的字符，将str1和str2中非lcs的部分加入结果
            // ab(ac), (c)ab
            // lcs当前是a

            // 对于str1，str1[0]是a，匹配lcs当前字符，所以不加任何到res中
            while (str1.charAt(i1) != c) {
                res.append(str1.charAt(i1));
                i1++;
            }

            // 对于str2，str2[0]是c，不匹配lcs当前字符，所以加入c, 更新i2
            // 对于str2，str2[1]是a，匹配lcs当前字符，所以不加任何到res中, 停止
            while (str2.charAt(i2) != c) {
                res.append(str2.charAt(i2));
                i2++;
            }

            // 添加lcs中的当前字符a
            res.append(c);
            // 更新
            i1++;
            i2++;
        }

        // 添加剩余的部分
        res.append(str1.substring(i1));
        res.append(str2.substring(i2));

        return res.toString();
    }
}