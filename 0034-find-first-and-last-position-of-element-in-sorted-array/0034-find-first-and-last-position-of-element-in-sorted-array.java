class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int leftMost = -1;
        int startIndex = 0;
        int endIndex = nums.length;
        while (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (nums[mid] == target) {
                leftMost = mid;
                endIndex = mid;
            } else if (nums[mid] < target) {
                startIndex = mid + 1;
            } else if (nums[mid] > target) {
                endIndex = mid;
            }
        }

        int rightMost = -1;
        startIndex = 0;
        endIndex = nums.length;
        while (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (nums[mid] == target) {
                rightMost = mid;
                startIndex = mid + 1;
            } else if (nums[mid] < target) {
                startIndex = mid + 1;
            } else if (nums[mid] > target) {
                endIndex = mid;
            }
        }

        return new int[]{leftMost, rightMost};
    }
}