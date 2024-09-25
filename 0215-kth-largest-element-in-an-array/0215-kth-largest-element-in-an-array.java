class Solution {
    // Function to find the k-th largest element using quickselect
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickselect(nums, 0, n - 1, n - k);
    }

    // Helper method for quickselect algorithm
    private int quickselect(int[] nums, int left, int right, int k) {
        // Using the first element as the pivot
        int pivot = nums[left];
        int i = left;
        int j = right;
        // Partitioning the array
        while (i <= j) {
            while (i <= j && nums[i] < pivot) i++;
            while (i <= j && nums[j] > pivot) j--;
            if (i <= j) {
                // Swap elements at i and j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        // Determine which part to recursively call quickselect on
        if (k <= j) return quickselect(nums, left, j, k);
        if (k >= i) return quickselect(nums, i, right, k);
        return nums[k];
    }
}
