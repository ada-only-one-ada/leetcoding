class Solution {
    public int minSwaps(int[] nums) {       
        int ones = 0;
        for (int num: nums) {
            ones += num;
        }

        int longestConsecutiveOnes = 0;
        int countOnes = 0;

        int left = 0;
        for (int right = 0; right < nums.length * 2; right++) {
            int num = nums[right % nums.length];
            countOnes += num;
            longestConsecutiveOnes = Math.max(longestConsecutiveOnes, countOnes);
           
            if (right - left + 1 == ones) {
                countOnes -= nums[left % nums.length];
                left++;
            }
        }

        return ones - longestConsecutiveOnes;
    }
}