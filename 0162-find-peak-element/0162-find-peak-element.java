class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean largerThanLeftNei = mid - 1 == -1 || nums[mid] > nums[mid - 1];
            boolean largerThanRightNei = mid + 1 == nums.length || nums[mid] > nums[mid + 1];

            if (largerThanLeftNei && largerThanRightNei) {
                return mid;
            } else if (mid + 1 < nums.length && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}