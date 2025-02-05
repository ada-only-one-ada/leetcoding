class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int bigIndex = nums.length - 1;
        while (bigIndex >= 0 && nums[bigIndex] <= nums[i]) {
            bigIndex--;
        }

        swap(nums, bigIndex, i);
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}