class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) return nums[0];

        int start = 0;
        int end = nums.length;
        while (start < end) {
           
            int mid = start + (end - start) / 2;

            // 左边是递增的，意味着最小值可能是左边第一个，或者是 mid - end 的一个
            // 右边递减的
            if (nums[start] < nums[mid]) {
                if (nums[start] < nums[end - 1]) {
                    return nums[start];
                } else {
                    start = mid + 1;
                }

            // 右边是递增的，意味着最小值可能是mid，或者是 start - mid 的一个
            // 左边是递减的
            } else if (nums[mid] <= nums[end - 1]) {
                if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                } else {
                    end = mid;
                }
            }
        }

        return nums[start];
    }
}