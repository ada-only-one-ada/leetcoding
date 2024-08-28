class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] >= nums[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()] && stack.size() - 1 + (nums.length - i) >= k) {
                    stack.pop();
                }

                stack.push(i);
            }
        }

        int[] res = new int[k];
        while (!stack.isEmpty() && stack.size() > k) {
            stack.pop();
        }

        for (int i = res.length - 1; i >= 0 && !stack.isEmpty(); i--) {
            res[i] = nums[stack.pop()];
        }
        return res;
    }
}