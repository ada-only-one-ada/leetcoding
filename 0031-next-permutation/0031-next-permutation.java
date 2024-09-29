class Solution {
    public void nextPermutation(int[] nums) {
        int lowerIndex = nums.length - 2;
        while (lowerIndex >= 0 && nums[lowerIndex] >= nums[lowerIndex + 1]) {
            lowerIndex--;
        }

        if (lowerIndex < 0) { 
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int higherIndex = nums.length - 1;
        while (higherIndex >= 0 && nums[higherIndex] <= nums[lowerIndex]) {
            higherIndex--;
        }

        int temp = nums[lowerIndex];
        nums[lowerIndex] = nums[higherIndex];
        nums[higherIndex] = temp;

        reverse(nums, lowerIndex + 1, nums.length - 1);
    }

    public void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}