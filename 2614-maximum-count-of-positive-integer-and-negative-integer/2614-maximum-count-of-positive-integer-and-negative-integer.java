class Solution {
    public int maximumCount(int[] nums) {
        // 找第一个出现的正数
        int left = 0;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 当前数字是正数，说明第一个正数肯定是当前或之前
            if (nums[mid] > 0) {
                right = mid;
            // 当前数字不是正数，说明第一个正数肯定在之后
            } else if (nums[mid] <= 0) {
                left = mid + 1;
            }
        }

        int numOfPosNums = 0;
        if (right >= 0 && right < nums.length && nums[right] > 0) {
            numOfPosNums = nums.length - right;
        }
        if (left >= 0 && left < nums.length && nums[left] > 0) {
            numOfPosNums = nums.length - left;
        }

        // 找最后一个出现的负数
        left = 0;
        right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 当前数字是负数，说明最后一个负数肯定在当前或之后
            if (nums[mid] < 0) {
                left = mid; 
            // 当前数字不是负数，说明最后一个负数肯定在之前
            } else if (nums[mid] >= 0) {
                right = mid - 1;
            }
        }
        
        int numOfNegNums = 0;
        if (left >= 0 && left < nums.length && nums[left ] < 0) {
            numOfNegNums = left  + 1;
        }
        if (right >= 0 && right < nums.length && nums[right] < 0) {
            numOfNegNums = right + 1;
        }

        return Math.max(numOfPosNums, numOfNegNums);
    }
}