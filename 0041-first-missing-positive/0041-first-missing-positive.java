class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // here swap stops until all numbers are in the correct index, not only swap once.
            while(nums[i] > 0 && nums[i]-1 < nums.length && nums[i] != nums[nums[i]-1] && nums[i] <= nums.length) {
                swap(nums, i, nums[i]-1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}