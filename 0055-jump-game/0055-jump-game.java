class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;

        int maxFar = nums[0];
        int currPos = 0;
       
        for (int i = currPos; i <= maxFar; i++) {
            if (maxFar >= nums.length - 1) return true;
            maxFar = Math.max(maxFar, i + nums[i]);
        }

        return false;
    }
}