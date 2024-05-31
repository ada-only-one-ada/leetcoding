class Solution {
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;
        for (int x : nums) {
            xorAll ^= x;
        }
        int lowbit = xorAll & -xorAll;
        int[] ans = new int[2];
        for (int x : nums) {
            ans[(x & lowbit) == 0 ? 0 : 1] ^= x; // 分组异或
        }
        return ans;
    }
}
