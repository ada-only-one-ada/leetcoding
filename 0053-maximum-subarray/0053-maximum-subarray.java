class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;

        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            if (sum + nums[right] > nums[right]) {
                sum += nums[right];
                res = Math.max(res, sum);
            } else {
                sum = nums[right];
                res = Math.max(res, sum);
            }
        }

        return res;
    }
}