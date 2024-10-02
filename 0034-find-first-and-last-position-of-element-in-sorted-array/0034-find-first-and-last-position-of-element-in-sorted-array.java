class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[]{-1, -1};
        if (nums.length == 0) return res;

        // first pos of target 
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 说明第一个target肯定在 mid，或者 mid 之前，往前找
            if (nums[mid] == target) {
                right = mid;
            // 说明第一个target肯定在 mid 之后
            } else if (nums[mid] < target) {
                left = mid + 1;
            // 说明第一个target肯定在 mid之前
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (nums[left] != target) return res;
        res[0] = left;

        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        res[1] = left;
        return res;
    }
}