class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int maxTime = 0;
            while (!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
                maxTime = Math.max(maxTime, stack.pop()[1]);
            }

            if (stack.isEmpty()) {
                stack.push(new int[]{nums[i], 0});
            } else {
                stack.push(new int[]{nums[i], maxTime + 1});
                res = Math.max(res, maxTime + 1);
            }
        }

        return res;
    }
}