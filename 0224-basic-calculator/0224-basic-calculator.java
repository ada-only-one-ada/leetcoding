class Solution {
    public int calculate(String s) {
        int prevSign = 1;
        Stack<Integer> stack = new Stack();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                int open = 1;
                int close = 0;
                int j = i + 1;
                while (close < open) {
                    if (s.charAt(j) == ')') {
                        close++;
                    } else if (s.charAt(j) == '(') {
                        open++;
                    }
                    j++;
                }

                num = calculate(s.substring(i + 1, j));
                i = j - 1;
            }

            if ((c != ' ' && (c == '+' || c == '-')) || i == s.length() - 1) {
                stack.push(num * prevSign);
                num = 0;
                if (c == '+') {
                    prevSign = 1;
                } else if (c == '-') {
                    prevSign = -1;
                } 
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}