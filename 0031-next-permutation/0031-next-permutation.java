class Solution {
    public void nextPermutation(int[] nums) {
        // 5,4,3,2,1 从右往左全部都是递增，这种情况下已经是最大的了，返回1,2,3,4,5
        // 1,1,5,4,3 -> 1,3,1,4,5

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i < 0) {
            Arrays.sort(nums);
            return;
        }

        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int tempNum = nums[left];
            nums[left] = nums[right];
            nums[right] = tempNum;
            left++;
            right--;
        }
    }
}