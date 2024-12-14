class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length + 1;

        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
            }

            while (sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
                minLen = Math.min(minLen, right - left + 1);
            }
        }

        return minLen == nums.length + 1? 0: minLen;
    }
}