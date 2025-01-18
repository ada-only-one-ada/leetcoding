class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // 左边最大，右边最小
        // 要比左边最大大，要比右边最小小
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        int leftMax = nums[0];
        int rightMin = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            leftMax = Math.max(leftMax, nums[i - 1]);
            if (nums[i] < leftMax) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        for (int i = nums.length - 2; i >= 0; i--){
            rightMin = Math.min(rightMin, nums[i + 1]);
            if (nums[i] > rightMin) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        if (start >= end) return 0; 
        return end - start + 1;
    }
}