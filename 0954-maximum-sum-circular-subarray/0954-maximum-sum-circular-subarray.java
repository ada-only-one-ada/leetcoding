class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        /*
          1、正常情况
          2、取两边最大（即找到连续子数组的和最小，总sum-最小子数组和即为答案）
          3、全是负数的情况
        */        

        // [-3,-2,-3]
        int totalSum = getTotalSum(nums); // -8
        int maxSubarraySum = getMaxSubarraySum(nums); // -2
        int minSubarraySum = getMinSubarraySum(nums); // -8

        int res = Integer.MIN_VALUE;
        res = Math.max(res, maxSubarraySum);   
        // 非全是负数的情况     
        if (totalSum != minSubarraySum) res = Math.max(res, totalSum - minSubarraySum);
        // 全是负数的情况
        if (totalSum == minSubarraySum) res = Math.max(res, getMinNum(nums));

        return res;
    }

    public int getTotalSum(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        return sum;
    }

    public int getMinNum(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        for (int num: nums) {
            minNum = Math.min(minNum, num);
        }
        return minNum;
    }

    public int getMaxSubarraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int prevSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= prevSum + nums[i]) {
                prevSum = nums[i];
            } else {
                prevSum += nums[i];
            }

            maxSum = Math.max(maxSum, prevSum);
        }
        return maxSum;
    }

    public int getMinSubarraySum(int[] nums) {
        int minSum = Integer.MAX_VALUE;

        int prevSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= prevSum + nums[i]) {
                prevSum = nums[i];
            } else {
                prevSum += nums[i];
            }

            minSum = Math.min(minSum, prevSum);
        }
        return minSum;
    }
}