class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        // 反转整个字符串
        reverse(nums, 0, nums.length - 1);
        // 反转 前 k-1 的子串
        reverse(nums, 0, k - 1);
        // 反转 k 到末尾的子串
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}