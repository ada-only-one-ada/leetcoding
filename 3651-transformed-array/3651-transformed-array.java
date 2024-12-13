class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int changeToIndex = (i + nums[i]) % nums.length;

            if (changeToIndex >= 0) {
                res[i] = nums[changeToIndex];
            } else {
                res[i] = nums[nums.length + changeToIndex];
            }
        }

        return res;
    }
}