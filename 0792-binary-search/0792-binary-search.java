class Solution {
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) return -1;

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
    }
}