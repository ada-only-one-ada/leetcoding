class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        /*
          1、正常情况
          2、取两边最大（即找到连续子数组的和最小，总sum-最小子数组和即为答案）
          3、全是负数的情况
        */        

        // [-3,-2,-3]
        int total = getTotalSum(nums); // -8
        int maxSub = getMaxSubarraySum(nums); // -2
        int minSub = getMinSubarraySum(nums); // -8

        int res = Integer.MIN_VALUE;
        res = Math.max(res, maxSub);        
        res = Math.max(res, total == minSub ? getMinNum(nums) : total - minSub);
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
        int res = Integer.MIN_VALUE;

        int prevSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= prevSum + nums[i]) {
                prevSum = nums[i];
            } else {
                prevSum += nums[i];
            }

            res = Math.max(res, prevSum);
        }
        return res;
    }

    public int getMinSubarraySum(int[] nums) {
        int res = Integer.MAX_VALUE;

        int prevSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prevSum + nums[i] < nums[i]) {
                prevSum += nums[i];
            } else {
                prevSum = nums[i];
            }

            res = Math.min(res, prevSum);
        }
        return res;
    }
}