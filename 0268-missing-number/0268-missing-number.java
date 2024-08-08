class Solution {
    public int missingNumber(int[] nums) {
        int res = 0 ^ nums[0];

        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i] ^ i;
        }

        res ^= nums.length;
        return res;
    }
}