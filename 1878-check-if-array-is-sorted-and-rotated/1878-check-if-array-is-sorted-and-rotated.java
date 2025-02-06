class Solution {
    public boolean check(int[] nums) {
        if (helper(nums, 0, nums.length - 1)) return true;

        int line = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                line = i;
                break;
            }
        }

        return helper(nums, 0, line - 1) && helper(nums, line, nums.length - 1) && nums[nums.length - 1] <= nums[0];
    }

    public boolean helper(int[] nums, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < nums[i-1]) return false;
        }

        return true;
    }
}