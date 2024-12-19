class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) return nums[0];

        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;

            // 左边是递增排序的的，意味着最小值可能是左边第一个，或者是 mid - end 的一个
            if (nums[start] < nums[mid]) {
                // 左边第一个比最后一个小，比如【4，5，7，8，6】
                // 因为右边是递减的，所以跟最后一个比较
                if (nums[start] < nums[end - 1]) {
                    return nums[start];
                // 否则，左边比最后一个大，比如【5，7，8，6，4】
                // 最小肯定在右边
                } else {
                    start = mid + 1;
                }
            // 右边是递增排序的，意味着最小值可能是 mid，或者是 start - mid 的一个
            } else if (nums[mid] <= nums[end - 1]) {
                // 左边是递减的，mid 跟 mid - 1 比，比如【8，6，4，5，7】
                if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                // 否则，往左边找
                } else {
                    end = mid;
                }
            }
        }

        return nums[start];
    }
}