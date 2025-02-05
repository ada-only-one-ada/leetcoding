class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start + 1 < nums.length && nums[start] == nums[start + 1]) start++;
        while (end - 3 >= 0 && nums[end - 1] == nums[end - 2]) end--;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else {
                /* 由于存在重复元素，需要处理跳过重复的情况
                if (nums[start] == nums[mid] && nums[end - 1] == nums[mid]) {
                    start++;
                    end--;
                } else*/ 
                if (nums[start] <= nums[mid]) {
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