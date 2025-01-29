class Solution {
    public void sortColors(int[] nums) {
        // 0,1,2

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }

        for (int right = left; right < nums.length; right++) {
            if (nums[right] == 1) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}