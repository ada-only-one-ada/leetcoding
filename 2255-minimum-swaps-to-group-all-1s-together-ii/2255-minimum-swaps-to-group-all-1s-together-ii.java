class Solution {
    public int minSwaps(int[] nums) {       
        int totalOnes = 0;
        for (int num: nums) {
            if (num == 1) totalOnes++;
        }

        int longestConsecutiveOnes = 0, currOnes = 0;
        int left = 0;
        for (int right = 0; right < nums.length * 2; right++) {
            int num = nums[right % nums.length];
            currOnes += num;

            if (right - left + 1 == totalOnes) {
                longestConsecutiveOnes = Math.max(longestConsecutiveOnes, currOnes);
                currOnes -= nums[left % nums.length];
                left++;
            }
        }

        return totalOnes - longestConsecutiveOnes;
    }
}