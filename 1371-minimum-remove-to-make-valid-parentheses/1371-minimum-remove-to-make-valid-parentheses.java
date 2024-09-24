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

                if (open == close) {
                    sb.append(c);
                    continue;
                } else if (open < close) {
                    close--;
                    continue;
                } else if (open > close) {
                    sb.append(c);
                }
            } 
        }
        
        int open2 = 0;
        int close2 = 0;
        StringBuilder sb2 = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);

            if (c != '(' && c != ')') {
                sb2.append(c);
            } else {
                if (c == '(') {
                    open2++;
                } else if (c == ')') {
                    close2++;
                }

                if (open2 == close2) {
                    sb2.append(c);
                    continue;
                } else if (open2 > close2) {
                    open2--;
                    continue;
                } else if (open2 < close2) {
                    sb2.append(c);
                }
            } 
        }
        
        return sb2.reverse().toString();
    }
}