class Solution {
    public int search(int[] nums, int target) {
        // 哪一段 sorted？
        if (nums[0] <= nums[nums.length - 1]) {
            int start = 0;
            int end = nums.length;

            while (start < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }    
           
            if (start >= 0 && start < nums.length && nums[start] == target) return start;
            return -1; 
        } else {
            int start = 0;
            int end = nums.length;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                }

                // 左边是 sorted 的
                if (nums[mid] >= nums[start]) {
                    if (nums[start] <= target && target <= nums[mid]) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                // 右边是 sorted 的
                } else if (nums[mid] <= nums[end - 1]) {
                    if (nums[mid] <= target && target <= nums[end - 1]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
            }

            if (start >= 0 && start < nums.length && nums[start] == target) return start;
            return -1; 
        }
    }
}