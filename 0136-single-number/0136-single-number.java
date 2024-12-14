class Solution {
    public int singleNumber(int[] nums) {
        // 0 xor any = any;
        // any xor any = 0;

        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            candidate = candidate ^ nums[i];
        }

        return candidate;
    }
}