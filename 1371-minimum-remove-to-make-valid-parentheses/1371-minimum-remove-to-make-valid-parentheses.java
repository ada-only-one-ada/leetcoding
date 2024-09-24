class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        int close = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (close + 1 > open) continue;
                close++;
            }
            sb.append(c);
        }

        if (open == close) return sb.toString();
        
        open = 0;
        close = 0;
        StringBuilder res = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == ')') {
                close++;
            } else if (c == '(') {
                if (open + 1 > close) continue;
                open++;
            }
            res.append(c);
        }

        return res.reverse().toString();
    }
}