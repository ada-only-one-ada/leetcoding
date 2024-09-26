class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
                // min 1 2 min,说明大数在右边
            } else if (nums[mid+1] > nums[mid]) {
                left = mid;
                // min 8 5 min，说明大数在左边
            } else if (nums[mid-1] > nums[mid]) {
                right = mid;
            }
        }

        if (nums[left] > nums[right]) return left;
        return right;
    }
}