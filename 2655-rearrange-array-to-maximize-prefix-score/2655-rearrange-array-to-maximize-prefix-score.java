class Solution {
    public int maxScore(int[] nums) {
        // 先把正数都加上，这样之后扣掉负数变成负数的越少
        // （正数最大的 - 负数最小的）

        long prefixSum = 0;
        int res = 0;

        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            prefixSum += nums[i];
            if (prefixSum > 0) {
                res++;
            }
        }

        return res;
    }
}