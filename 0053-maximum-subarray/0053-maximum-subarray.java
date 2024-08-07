class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= currSum + nums[i]) {
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}