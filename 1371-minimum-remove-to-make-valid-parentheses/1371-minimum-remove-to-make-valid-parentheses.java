class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        int close = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') {
                sb.append(c);
            } else {
                if (c == '(') {
                    open++;
                } else if (c == ')') {
                    close++;
                }

                if (open == close || open > close) {
                    sb.append(c);
                } else if (open < close) {
                    close--;
                } 
            } 
        }
        
        open = 0;
        close = 0;
        StringBuilder res = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);

            if (c != '(' && c != ')') {
                res.insert(0, c);
            } else {
                if (c == '(') {
                    open++;
                } else if (c == ')') {
                    close++;
                }

                if (open == close || open < close) {
                    res.insert(0, c);       
                } else if (open > close) {
                    open--;
                } 
            } 
        }
        
        return res.toString();
    }
}