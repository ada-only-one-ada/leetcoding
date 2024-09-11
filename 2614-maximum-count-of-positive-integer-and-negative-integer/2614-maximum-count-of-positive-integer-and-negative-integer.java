class Solution {
    public int maximumCount(int[] nums) {
        // 找第一个出现的正数
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 当前数字是正数，说明第一个正数肯定是当前或之前
            if (nums[mid] > 0) {
                right = mid;
            // 当前数字不是正数，说明第一个正数肯定在之后
            } else if (nums[mid] <= 0) {
                left = mid + 1;
            }
        }
        int firstPosIndex = left;
        int numOfPosNums = 0;
        if (firstPosIndex >= 0 && firstPosIndex < nums.length && nums[firstPosIndex] > 0) {
            numOfPosNums = nums.length - firstPosIndex;
        }

        // 找最后一个出现的负数
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 当前数字是负数，说明最后一个负数肯定在当前或之后
            if (nums[mid] < 0) {
                left = mid + 1; 
            // 当前数字不是负数，说明最后一个负数肯定在之前
            } else if (nums[mid] >= 0) {
                right = mid - 1;
            }
        }
        int lastNegIndex = left - 1;
        int numOfNegNums = 0;
        if (lastNegIndex >= 0 && lastNegIndex < nums.length && nums[lastNegIndex] < 0) {
            numOfNegNums = lastNegIndex + 1;
        }

        return Math.max(numOfPosNums, numOfNegNums);
    }
}