class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean greaterThanLeftNei = mid - 1 == -1 || nums[mid] > nums[mid - 1];
            boolean greaterThanRightNei = mid + 1 == nums.length || nums[mid] > nums[mid + 1];

            if (greaterThanLeftNei && greaterThanRightNei) {
                return mid;
            // mid + 1 更大，是一个可能的candidate
            } else if (mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}