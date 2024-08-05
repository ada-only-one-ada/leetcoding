class Solution {
    public void rotate(int[] nums, int k) {
        int[] rotateNums = new int[nums.length];
        k = k % nums.length;

        for (int i = 0; i < nums.length; i++) {
            rotateNums[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rotateNums[i];
        }
    }
}