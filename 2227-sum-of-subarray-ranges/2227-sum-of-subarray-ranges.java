class Solution {
    public long subArrayRanges(int[] nums) {
        int[] newNums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        nums = newNums;
        nums[nums.length - 1] = Integer.MAX_VALUE;
        long res = 0;

        Stack<Integer> stack = new Stack();
        stack.push(-1);
        
        // 左边第一个比它大的，右边第一个比它大的
        // 那么计算当前 number 对最大值贡献了多少
        for (int i = 0; i < nums.length; i++) {
            if (stack.size() <= 1 || nums[i] <= nums[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.size() >= 2 && nums[i] > nums[stack.peek()]) {
                    int right = i;
                    int mid = stack.pop();
                    int left = stack.peek();
                    res += (long) nums[mid] * (right - mid) * (mid - left);
                }
                stack.push(i);
            }
        }   

        stack.clear();
        nums[nums.length - 1] = Integer.MIN_VALUE;
        stack.push(-1);
        // 左边第一个比它小的，右边第一个比它小的
        // 那么计算当前 number 对最小值贡献了多少
        for (int i = 0; i < nums.length; i++) {
            if (stack.size() <= 1 || nums[i] >= nums[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.size() >= 2 && nums[i] < nums[stack.peek()]) {
                    int right = i;
                    int mid = stack.pop();
                    int left = stack.peek();
                    res -= (long) nums[mid] * (right - mid) * (mid - left);
                }
                stack.push(i);
            }
        }

        return res;
    }
}