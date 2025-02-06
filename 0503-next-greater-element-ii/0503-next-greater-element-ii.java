class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < nums.length * 2; i++) {
            int index = i % nums.length;

            if (stack.isEmpty() || nums[index] <= nums[stack.peek()]) {
                stack.push(index);
            } else {
                while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                    res[stack.pop()] = nums[index];
                }
                stack.push(index);
            }
        }



        return res;
    }
}