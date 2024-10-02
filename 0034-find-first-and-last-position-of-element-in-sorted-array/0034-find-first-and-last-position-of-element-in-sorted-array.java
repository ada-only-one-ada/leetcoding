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
        int rightMost = -1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 最后一个是mid，或者mid之后
            if (nums[mid] == target) {
                rightMost = mid;
                left = mid + 1;
            // 最后一个肯定在mid之后
            } else if (nums[mid] < target) {
                left = mid + 1;
            // 最后一个肯定在mid之前
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        res[1] = rightMost;
        return res;
    }
}