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
            // 累计统计当前的 1
            countOnes += num;
            // 最长连续的 1 的长度
            longestConsecutiveOnes = Math.max(longestConsecutiveOnes, countOnes);
            
            // 达到数量了，移动左窗口，即我们只关注包含 ones 个 1 的窗口
            if (right - left + 1 == ones) {
                countOnes -= nums[left % nums.length];
                left++;
            }
        }

        // 总移动数就是要把剩下的 1 加入到这个最长串的 1 的 group
        // 因为这表示我们需要将剩余的 1 移动到这个连续段中，以形成一个完整的连续 1 段
        return ones - longestConsecutiveOnes;
    }
}