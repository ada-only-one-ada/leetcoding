class Solution {
    int res = 0;
    public int arrayNesting(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                helper(nums, i, 0);
            }
        }

        return res;
    }

    public void helper(int[] nums, int index, int len) {
        if (index < 0 || index >= nums.length) {
            res = Math.max(res, len);
            return;
        }

        if (nums[index] == -1) {
            res = Math.max(res, len);
            return;
        }

        int nextIndex = nums[index];
        nums[index] = -1;
        helper(nums, nextIndex, len + 1);
    }
}