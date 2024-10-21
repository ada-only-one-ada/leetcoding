class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int res = 0;

        for (int num: nums) {
            // 先于 num 之前被删掉的元素当中，删除花的最大次数
            int currMax = 0;
            // stack.peek()[0] 是先于 num 之前，被同一个大数删掉的
            while (!stack.isEmpty() && stack.peek()[0] <= num) {
                currMax = Math.max(currMax, stack.pop()[1]);
            }
            
            // [4, 1, 2, 3]
            // [3, 3]
            // [2, 2] pop 
            // [1, 1] pop       [1, 1] // 这里应该是 max + 1
            // [4, 0]           [4, 0]

            // 说明这个元素左边没有要被删掉的元素
            if (stack.isEmpty()) {
                stack.push(new int[]{num, 0});
            } else {
                // [10, 1, 2, 3]
                // 3被10消
                // 但10消3之前，10要先消1，先消2 
                // 我们用消2的次数 + 1，就是消3的要花的总次数
                stack.push(new int[]{num, currMax + 1});
                res = Math.max(res, currMax + 1);
            }
        }

        return res;
    }
}