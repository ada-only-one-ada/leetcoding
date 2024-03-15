class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];

        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        int[] suffix = new int[nums.length];
        suffix[suffix.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = nums[i+1] * suffix[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }
}

// [(1, (1,  2,  6)]
// [(24, 12, 4), 1]