class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posIndex = 0;
        int negIndex = 1;
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                res[posIndex] = nums[i];
                posIndex += 2;
            } else {
                res[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return res;
    }
}