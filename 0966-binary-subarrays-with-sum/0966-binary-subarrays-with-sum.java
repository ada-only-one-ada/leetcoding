class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int leftCount = 1;  // 初始化为1，处理没有前导零的情况
        int sum = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // 确保我们始终在检查一个和不大于 goal 的窗口
            while (sum > goal && left < right) {
                sum -= nums[left];
                left++;
                leftCount = 1; // 如果当前和超过目标值，重置 leftCount
            }

            // 处理前导零：当窗口的和 sum 恰好等于 goal 时，说明找到了一个满足条件的子数组
            // 如果左边界元素为 0，意味着左边界可以继续向右扩展，且扩展过程中子数组的和仍然等于 goal
            // 因此 leftCount 会增加，这样的扩展会产生多个满足条件的子数组
            if (sum == goal) {
                while (left < right && nums[left] == 0) {
                    leftCount++;
                    left++;
                }

                res += leftCount;
            }
        }

        return res;
    }
}
