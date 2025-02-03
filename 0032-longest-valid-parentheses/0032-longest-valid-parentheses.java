class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;

        int open = 0;
        int close = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') open++;
            else if (c == ')') close++;

            if (close > open) {
                open = 0;
                close = 0;
            }

            if (open == close) {
                res = Math.max(res, open + close);
            }
        }

        // (()
        open = 0;
        close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') close++;
            else if (s.charAt(i) == '(') open++;

            if (open > close) {
                open = 0;
                close = 0;
            }

            if (open == close) {
                res = Math.max(res, open + close);
            }
        }

        return res;
    }
}