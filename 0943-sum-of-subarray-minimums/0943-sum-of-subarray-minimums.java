class Solution {
    public int sumSubarrayMins(int[] arr) {
        // 左边第一个比他小，右边第一个比它小
        int[] nums = new int[arr.length + 2];
        nums[0] = Integer.MIN_VALUE;
        nums[nums.length - 1] = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            nums[i + 1] = arr[i];
        }
        arr = nums;

        long res = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            if (stack.size() < 2 || arr[i] >= arr[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.size() >= 2 && arr[i] < arr[stack.peek()]) {
                    int right = i;
                    int mid = stack.pop();
                    int left = stack.peek();

                    res += (long) arr[mid] * (mid - left) * (right - mid);
                }
                stack.push(i);
            }
        }

        return (int)(res % 1000000007);
    }
}