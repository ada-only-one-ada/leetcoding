class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    public int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            // 当前数字比 target 大，说明第一次出现肯定在前面
            // 当前数字等于 target，说明第一次可能是当前，也可能在前面
            if (nums[mid] >= target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } 
        }

        if (start >= 0 && start < nums.length && nums[start] == target) return start;
        return -1;
    }

    public int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        int saved = -1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            // 当前数字比 target 大，说明最后一个肯定在之前
            if (nums[mid] > target) {
                end = mid;
            // 当前数字小于 target，肯定在最后
            // 当前数字等于 target，可能是当前，也可能在之后，先存起来
            } else if (nums[mid] <= target) {
                saved = mid;
                start = mid + 1;
            } 
        }

        if (saved >= 0 && saved < nums.length && nums[saved] == target) return saved;
        return -1;
    }
}