class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int start = 0, end = n;
        // Find the first positive number
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > 0) {
                end = mid; // move end to mid to close in
            } else {
                start = mid + 1; // adjust start to mid + 1
            }
        }
        int pos = start < n && nums[start] > 0 ? n - start : 0;

        // Find the last negative number
        start = 0;
        end = n - 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2; // adjust to ceil to ensure progression
            if (nums[mid] < 0) {
                start = mid; // this is fine because we adjust mid calculation
            } else {
                end = mid - 1;
            }
        }
        int neg = nums[start] < 0 ? start + 1 : 0;

        return Math.max(pos, neg);
    }
}
