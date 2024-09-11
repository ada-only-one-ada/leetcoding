class Solution {
    public int maximumCount(int[] nums) {
        int start = 0;
        int end = nums.length;
        // 找第一个正数
        while (start < end) {
            int mid = start + (end - start) / 2;
            // 当前数字大于0，第一个正数可能是当前或之前的
            if (nums[mid] > 0) {
                end = mid;
            } else {
                // 当前小于等于0，第一个正数肯定在当前之后
                start = mid + 1;
            }
        }
        
        int pos = start >= 0 && start < nums.length && nums[start] > 0? nums.length - start : 0;

        // 找最后一个负数
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 当前数字小于0，可能是最后一个负数，也可能之后还有
            if (nums[mid] < 0) {
                start = mid + 1;
            // 当前数字大于0等于0，说明最后一个负数肯定在之前
            } else {
                end = mid - 1;
            }
        }

        int neg = start - 1 >= 0 && nums[start - 1] < 0? start : 0;
        return Math.max(pos, neg);
    }
}