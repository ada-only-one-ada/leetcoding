class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();

        for (int a: asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                // size 一样，都爆炸
                if (Math.abs(stack.peek()) == Math.abs(a)) {
                    a = 0;
                    stack.pop();
                    break;
                // 小的爆炸
                } else if (Math.abs(stack.peek()) > Math.abs(a)) {
                    a = 0;
                    break;
                } else if (Math.abs(stack.peek()) < Math.abs(a)) {
                    stack.pop();
                }
            }

            if (a != 0) stack.push(a);
        }
        int[] res = new int[stack.size()];
        int index = stack.size() - 1;

        while (!stack.isEmpty()) {
            res[index--] = stack.pop();
        }
        
        return res;
    }
}