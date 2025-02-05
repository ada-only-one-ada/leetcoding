class Solution {
    public int maxProduct(int[] nums) {
        int[] minDp = new int[nums.length];
        int[] maxDp = new int[nums.length];
        
        minDp[0] = nums[0];
        maxDp[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                minDp[i] = Math.min(nums[i], minDp[i-1] * nums[i]);
                maxDp[i] = Math.max(nums[i], maxDp[i-1] * nums[i]);
            } else if (nums[i] < 0) {
                minDp[i] = Math.min(nums[i], maxDp[i-1] * nums[i]);
                maxDp[i] = Math.max(nums[i], minDp[i-1] * nums[i]);
            }
            res = Math.max(res, maxDp[i]);
        }

        return res;
    }
}