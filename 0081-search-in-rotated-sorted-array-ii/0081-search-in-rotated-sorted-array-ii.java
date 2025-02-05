class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else {
                if (nums[start] == nums[mid] && nums[end - 1] == nums[mid]) {
                    start++;
                    end--;
                } else if (nums[start] <= nums[mid]) {
                    if (nums[start] <= target && target < nums[mid]) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                } else if (nums[mid] <= nums[end - 1]) {
                    if (nums[mid] < target && target <= nums[end - 1]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
            }
        }

        return false;
    }
}