class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long[] count = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count[i] = 1;
            }
            if (i == 0 || count[i] == 0) continue;
            count[i] += count[i - 1];
        }

        long sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];

            if (count[i] == 0) {
                res += sum;
                sum = 0;
            }
        }

        if (sum != 0) res += sum;

        return res;
    }
}