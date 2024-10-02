class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    public int findFirst(int[] nums, int target) {
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

    public int findLast(int[] nums, int target) {
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