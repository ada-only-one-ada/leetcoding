class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[]{-1, -1};
        if (nums.length == 0) return res;

        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left >= 0 && left < nums.length && nums[left] == target) {
            res[0] = left;
        } else {
            return res;
        }

        left = 0;
        right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        res[1] = left;
        return res;
    }
}