class Solution {
    public int search(int[] nums, int target) {
        if (nums[0] <= nums[nums.length - 1]) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return -1;
        } else {
            int left = 0;
            int right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[0] <= nums[mid]) {
                    if (nums[0] <= target && target < nums[mid]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] <= nums[nums.length - 1]) {
                    if (nums[mid] < target && target <= nums[nums.length - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
            return -1;
        }
    }
}