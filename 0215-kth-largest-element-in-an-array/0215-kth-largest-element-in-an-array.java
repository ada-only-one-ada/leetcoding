class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int left, int right, int kSmall) {
        int i = left;
        int j = right;
        int pivot = nums[left];

        while (i <= j) {
            while (i <= j && nums[i] < pivot) i++;
            while (i <= j && nums[j] > pivot) j--;

            if (i <= j) {
                int temp= nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        if (kSmall <= j) return quickSelect(nums, left, j, kSmall);
        if (kSmall >= i) return quickSelect(nums, i, right, kSmall);

        return nums[kSmall];
    }
}