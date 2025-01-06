class Solution {
    public int evalRPN(String[] tokens) {
        // 只包含：+ - * / 和数字[-200, 200]

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String currToken = tokens[i];

            if (currToken.equals("+") || currToken.equals("-") || currToken.equals("*") || currToken.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();

                if (currToken.equals("+")) {
                    stack.push(num1 + num2);
                } else if (currToken.equals("-")) {
                    stack.push(num1 - num2);
                } else if (currToken.equals("*")) {
                    stack.push(num1 * num2);
                } else if (currToken.equals("/")) {
                    stack.push(num1 / num2);
                }
            } else {
                stack.push(Integer.valueOf(currToken));
            }
        }

        return stack.peek();
    }
}