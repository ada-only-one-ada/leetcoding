class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;

        int currFar = nums[0];
        int nextMostFar = nums[0];

        for (int i = 0; i <= currFar; i++) {
            nextMostFar = Math.max(nextMostFar, nums[i] + i);

            if (nextMostFar >= nums.length - 1) return true;
            currFar = nextMostFar;
        }

        return false;
    }
}