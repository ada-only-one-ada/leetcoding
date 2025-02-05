class Solution {
    public int maxProduct(int[] nums) {
        int[] minDp = new int[nums.length];
        int[] maxDp = new int[nums.length];
        minDp[0] = nums[0];
        maxDp[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                minDp[i] = Math.min(minDp[i-1] * nums[i], nums[i]);
                maxDp[i] = Math.max(maxDp[i-1] * nums[i], nums[i]);
            } else {
                minDp[i] = Math.min(maxDp[i-1] * nums[i], nums[i]);
                maxDp[i] = Math.max(minDp[i-1] * nums[i], nums[i]);
            }
            res = Math.max(res, maxDp[i]);
        }
        return res;
    }
}