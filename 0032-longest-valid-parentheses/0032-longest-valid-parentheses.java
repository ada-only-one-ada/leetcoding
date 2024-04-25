class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        int open = 0;
        int close = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(') {
                open++;
            } else if (curr == ')') {
                close++;
            }

            if (close > open) {
                open = 0;
                close = 0;
            } else if (open == close) {
                res = Math.max(res, open + close);
            } 
        }

        open = 0;
        close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char curr = s.charAt(i);

            if (curr == '(') {
                open++;
            } else if (curr == ')') {
                close++;
            }

            if (open > close ) {
                open = 0;
                close = 0;
            } else if (open == close ) {
                res = Math.max(res, open + close);
            }
        }

        return res;
    }
}