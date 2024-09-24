class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nums = new int[arr.length + 2];
        nums[0] = nums[nums.length - 1] = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            nums[i + 1] = arr[i];
        }

        long res = 0;

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < nums.length; i++) {
            if (stack.size() < 2 || nums[i] >= nums[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.size() >= 2 && nums[i] < nums[stack.peek()]) {
                    int right = i;
                    int mid = stack.pop();
                    int left = stack.peek();

                    res += (long)(right - mid) * (mid - left) * nums[mid];
                }
                stack.push(i);
            }
        }

        return (int)(res % 1000000007);
    }
}