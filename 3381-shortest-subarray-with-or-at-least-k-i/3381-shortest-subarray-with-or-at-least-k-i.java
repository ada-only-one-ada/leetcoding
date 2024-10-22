class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int orSum = 0;
        int res = nums.length + 1;

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                return 1;
            }

            orSum |= nums[i];

            while (orSum >= k && left < i) {
                res = Math.min(i - left + 1, res);
                left++;
                int newOrSum = 0;
                for (int j = left; j <= i; j++) {
                    newOrSum |= nums[j];
                }
                orSum = newOrSum;
            }
        }   

        return res != nums.length + 1 ? res : -1;
    }
}