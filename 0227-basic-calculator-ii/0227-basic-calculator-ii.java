class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();

        int value = 0;
        char prevSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c) || i == s.length() - 1) {
                if (c != ' ') value = value * 10 + (c - '0');        
                if (i == s.length() - 1) {
                    if (prevSign == '+') stack.push(value);
                    else if (prevSign == '-') stack.push(-value);
                    else if (prevSign == '*') stack.push(stack.pop() * value);
                    else if (prevSign == '/') stack.push(stack.pop() / value);
                }
            } else {
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    if (prevSign == '+') stack.push(value);
                    else if (prevSign == '-') stack.push(-value);
                    else if (prevSign == '*') stack.push(stack.pop() * value);
                    else if (prevSign == '/') stack.push(stack.pop() / value);

                    value = 0;
                    prevSign = c;
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