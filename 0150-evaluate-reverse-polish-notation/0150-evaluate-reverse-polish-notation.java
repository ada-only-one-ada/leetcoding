class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.valueOf(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (token.equals("+")) stack.push(num1 + num2);
                if (token.equals("-")) stack.push(num1 - num2);
                if (token.equals("*")) stack.push(num1 * num2);
                if (token.equals("/")) stack.push(num1 / num2);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}