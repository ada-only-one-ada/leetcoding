class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        char prevSign = ' ';
        while (i < s.length()) {
            char c = s.charAt(i);

            // 遇到数字了
            if (Character.isDigit(c)) {
                int num = 0;
                // 就要把这个数字处理到底
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }

                // 结合之前的prevSign，把这个数字收获结果
                if (prevSign == '-') {
                    stack.push(-num);
                } else if (prevSign == '*') {
                    stack.push(stack.pop() * num);
                } else if (prevSign == '/') {
                    stack.push(stack.pop() / num);
                } else {
                    stack.push(num);
                }
            } else {
                if (c == ' ') {
                    i++;
                } else {
                    prevSign = c;
                    i++;
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