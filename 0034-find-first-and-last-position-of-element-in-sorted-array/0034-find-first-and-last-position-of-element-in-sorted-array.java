class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstPos(nums, target);
        int last = findLastPos(nums, target);
        return new int[]{first, last};
    }

    public int findFirstPos(int[] nums, int target) {
        int candidate = -1;

        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                candidate = mid;
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }
        
        return candidate;
    }

    public int findLastPos(int[] nums, int target) {
        int candidate = -1;

        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                candidate = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }

        return candidate;
    }
}