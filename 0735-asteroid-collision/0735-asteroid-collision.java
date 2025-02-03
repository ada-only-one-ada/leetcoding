class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int aster : asteroids) {
            // 当前小行星向左移动，且栈顶小行星向右移动时，才会发生碰撞
            while (!stack.isEmpty() && aster < 0 && stack.peek() > 0) {
                if (stack.peek() < -aster) { // 栈顶小行星更小，爆炸
                    stack.pop();
                } else if (stack.peek() == -aster) { // 两者大小相同，都爆炸
                    stack.pop();
                    aster = 0; // 当前小行星也爆炸
                    break;
                } else { // 栈顶小行星更大，当前小行星爆炸
                    aster = 0;
                    break;
                }
            }
            if (aster != 0) { // 如果当前小行星没有爆炸，加入栈中
                stack.push(aster);
            }
        }

        // 将栈转换为数组（保持原始顺序）
        int[] res = new int[stack.size()];
        int index = stack.size() - 1;

        while (!stack.isEmpty()) {
            res[index--] = stack.pop();
        }
        
        
        return res;
    }
}