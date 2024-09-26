class Solution {
    public int findPeakElement(int[] nums) {
        // [-2147483648] expect 0
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > getValue(mid - 1, nums) && nums[mid] > getValue(mid + 1, nums)) {
                return mid;
            } else if (nums[mid] < getValue(mid + 1, nums)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int getValue(int index, int[] nums) {
        if (index < 0 || index >= nums.length) {
            return Integer.MIN_VALUE;
        } else {
            return nums[index];
        }
    }
}