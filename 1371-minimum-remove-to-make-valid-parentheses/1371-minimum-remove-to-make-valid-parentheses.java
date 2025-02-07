class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' &&  c != ')') {
                sb.append(c);
            } else if (c == '(') {
                open++;
                sb.append(c);
            } else if (c == ')') {
                if (close == open) continue;
                sb.append(c);
                close++;
            }
        }

        open = 0;
        close = 0;

        StringBuilder res = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);

            if (c != '(' &&  c != ')') {
                res.append(c);
            } else if (c == ')') {
                close++;
                res.append(c);
            } else if (c == '(') {
                if (close == open) continue;
                res.append(c);
                open++;
            }
        }

        return res.reverse().toString();
    }
}

