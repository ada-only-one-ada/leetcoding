class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int orSum = 0;
        int minLen = nums.length + 1;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] >= k) {
                return 1;
            }

            orSum |= nums[right];

            while (left < nums.length && orSum >= k) {
                minLen = Math.min(minLen, right - left + 1);
                left++;

                orSum = 0;
                for (int j = left; j <= right; j++) {
                    orSum |= nums[j];
                }
            }
        }

        return minLen != nums.length + 1 ? minLen : -1;
    }
}