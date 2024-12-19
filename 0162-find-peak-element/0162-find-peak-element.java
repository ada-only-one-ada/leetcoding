class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if ((mid - 1 == -1 || nums[mid] > nums[mid - 1]) && (mid + 1 == nums.length || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }  

        return start;
    }
}