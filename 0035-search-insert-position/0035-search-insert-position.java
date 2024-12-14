class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        int res = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            // 当前数字大于target，肯定在这之前
            } else if (nums[mid] > target) {
                end = mid;
            // 当前数字小于target，可能插入在当前位置之后一个，也可能之后
            } else if (nums[mid] < target) {
                res = mid;
                start = mid + 1;
            }
        }

        return res + 1;
    }
}