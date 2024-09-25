class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int left, int right, int kSmallest) {
        int i = left;
        int j = right;
        int pivot = nums[left];

        while (i <= j) {
            while (i <= j && nums[i] < pivot) i++;  // 这里不能是<=
            // 比如【3，3，3，3】在上面这个loop里，i会到数组长度，j不变，在上面这行就退出整个 whileloop了
            while (i <= j && nums[j] > pivot) j--;

            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp; 
                i++;
                j--;
            }  
        }

        // 在这里的时候，left没变，j也没变，造成stack overflow了
        if (kSmallest <= j) return quickSelect(nums, left, j, kSmallest);
        if (kSmallest >= i) return quickSelect(nums, i, right, kSmallest);
        return nums[kSmallest];
    }
}