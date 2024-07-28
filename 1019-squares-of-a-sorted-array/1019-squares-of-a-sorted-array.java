class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = res.length - 1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (Math.abs(nums[right]) >= Math.abs(nums[left]) ) {
                res[i] = nums[right] * nums[right];
                right--;
            } else {
                res[i] = nums[left] * nums[left];
                left++;
            }
            i--;
        }

        return res;
    }
}