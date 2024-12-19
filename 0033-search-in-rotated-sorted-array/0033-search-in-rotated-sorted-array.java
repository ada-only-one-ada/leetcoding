class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            // mid直接找到了 target，直接返回 mid
            if (nums[mid] == target) {
                return mid;
            // 否则，继续找，怎么找呢？
            } else {
                // 左半边是递增的：比如【4，5，6，7，0，1，2】，这里【4，5，6，7】是有序的
                if (nums[start] <= nums[mid]) {
                    //刚好target的范围又落在左半边，那答案肯定是在左半边
                    if (nums[start] <= target && target < nums[mid]) {
                        end = mid;
                    // 否则，肯定不在左半边
                    } else {
                        start = mid + 1;
                    }
                // 否则，左半边不是递增有序的，但是右半边是递增有序的，比如【9，1，2，5，6，7，8】，这里【5，6，7，8】是有序的
                } else if (nums[mid] <= nums[end - 1]) {
                    // 刚好target的范围又落在右半边，那答案肯定是在右半边
                    if (nums[mid] < target && target <= nums[end - 1]) {
                        start = mid + 1;
                    // 否则，肯定不在右半边
                    } else {
                        end = mid;
                    }
                }
            }
        }

        if (start < 0 || start >= nums.length || nums[start] != target) return -1;
        return start;
    }
}