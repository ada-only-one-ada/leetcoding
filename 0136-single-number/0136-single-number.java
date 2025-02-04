class Solution {
    public int singleNumber(int[] nums) {
        int candidate = 0;
        // o ^ any = any
        // any ^ any = 0;

        for (int num: nums) {
            candidate ^= num;
        }

        return candidate;
    }
}