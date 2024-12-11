class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int zeros = 0;
        int ones = 0;

        for (char c: s.toCharArray()) {
            // 当前字符是0
            if (c == '0') {
                // 如果之前有1，说明这是一个新开始：1101
                if (ones > 0) {
                    zeros = 0;
                    ones = 0;
                }
                zeros++;
            } else if (c == '1') {
                ones++;
                // 00011，0011，1的数量小于等于0
                if (ones <= zeros) {
                    // 取小的那段
                    res = Math.max(res, Math.min(zeros, ones) * 2);
                }
            }
        }

        return res;
    }
}