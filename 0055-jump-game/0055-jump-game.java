class Solution {
    public boolean canJump(int[] nums) {
        int maxPos = nums[0];

        for (int i = 0; i <= maxPos; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (maxPos >= nums.length - 1) return true;
        }

        return false;
    }
}