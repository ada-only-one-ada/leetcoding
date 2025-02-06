class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (!Character.isDigit(c)) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));

                for (int num1: left) {
                    for (int num2: right) {
                        if (c == '+') {
                            res.add(num1 + num2);
                        } else if (c == '-') {
                            res.add(num1 - num2);
                        } else if (c == '*') {
                            res.add(num1 * num2);
                        }
                    }
                }
            }
        }
        
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }

        return res;
    }
}