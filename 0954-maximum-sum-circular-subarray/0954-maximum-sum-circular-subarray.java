class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // 1. 检查是否同 53 题一样无环的情况，最大连续子序和，那我们直接找最大的就行
        // 2. 检查最大是否结果在两边的环，那我们找到 情况1 中最小连续子序和，总sum 减掉它即为两边的最大连续子序列和
        // 3. 如果 nums 中所有元素都是负数，我们直接返回 情况1 中最大连续子序和。如果按照 情况2 中，减掉一个负数，反而变成负负得正了

        // 因为下面的 loop 从 1 开始，我们要检查 len 为 1 的情况
        if (nums.length == 1) return nums[0];
        int totalSum = nums[0];

        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        int currMaxSum = nums[0];
        int currMinSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 最大子数组和
            if (currMaxSum + nums[i] > nums[i]) {
                currMaxSum += nums[i];
            } else {
                currMaxSum = nums[i];
            }
            maxSum = Math.max(maxSum, currMaxSum);

            // 最小子数组和
            if (currMinSum + nums[i] < nums[i]) {
                currMinSum += nums[i];
            } else {
                currMinSum = nums[i];
            }
            minSum = Math.min(minSum, currMinSum);

            // 总和
            totalSum += nums[i];
        }

        if (totalSum == minSum) return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
}