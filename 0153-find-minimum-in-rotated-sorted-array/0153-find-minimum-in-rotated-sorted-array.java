class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length;
        int res = Integer.MAX_VALUE;

        while (start < end) {
            int mid = start + (end - start) / 2;
            res = Math.min(res, nums[mid]);

            if (nums[start] <= nums[mid]) {
                if (nums[start] < nums[end - 1]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] <= nums[end - 1]) {
                if (nums[mid - 1] < nums[end - 1]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
        }

        return Math.min(res, nums[start - 1]);
    }
}