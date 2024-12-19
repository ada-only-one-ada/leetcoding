class Solution {
    public int search(int[] nums, int target) {
        // 如果已经排序好了，就按照正常的二分去找
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
        // 如果没有排序
        } else {
            int start = 0;
            int end = nums.length;
            while (start < end) {
                int mid = start + (end - start) / 2;
                // 找到了 target，直接返回
                if (nums[mid] == target) {
                    return mid;
                }

                // 否则，左边是 sorted 的
                if (nums[mid] >= nums[start]) {
                    // 且 target 在左边的范围
                    if (nums[start] <= target && target <= nums[mid]) {
                        // 去掉右边
                        end = mid;
                    } else {
                        // 否则，肯定不在左边
                        start = mid + 1;
                    }
                // 右边是 sorted 的
                // 注意：这里要用 end - 1
                } else if (nums[mid] <= nums[end - 1]) {
                    // 且 target 在右边的范围
                    if (nums[mid] <= target && target <= nums[end - 1]) {
                        // 去掉左边
                        start = mid + 1;
                    } else {
                        // 否则，肯定不在右边
                        end = mid;
                    }
                }
            }

            if (start >= 0 && start < nums.length && nums[start] == target) return start;
            return -1; 
        }
    }
}