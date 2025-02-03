class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char prevSign = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } 
                if (i == s.length() - 1) {
                    if (prevSign == '+') stack.push(num);
                    else if (prevSign == '-') stack.push(-num);
                    else if (prevSign == '*') stack.push(stack.pop() * num);
                    else if (prevSign == '/') stack.push(stack.pop() / num);

                } else if (c != ' ' && (c == '+' || c == '-' || c == '*' || c == '/')) {
                    if (prevSign == '+') stack.push(num);
                    else if (prevSign == '-') stack.push(-num);
                    else if (prevSign == '*') stack.push(stack.pop() * num);
                    else if (prevSign == '/') stack.push(stack.pop() / num);
                    prevSign = c;
                    num = 0;
                }
            
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}