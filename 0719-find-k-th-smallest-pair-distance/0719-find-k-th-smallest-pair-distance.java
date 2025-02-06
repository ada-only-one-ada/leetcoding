class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // 对数组进行排序，以便于计算距离
        Arrays.sort(nums);
        int n = nums.length;
        // 确定二分搜索的范围，基于最小和最大距离
        int left = 0, right = nums[n - 1] - nums[0];
        int ans = 0;

        // 使用二分搜索来找到第k小的距离
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 使用辅助函数来计算距离小于等于mid的对数
            int count = countPairsWithDistanceLessThan(nums, mid);

            // 根据对数来调整搜索范围
            if (count >= k) {
                ans = mid; // 如果对数足够，则更新答案
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // 辅助函数：计算距离小于等于给定值的对数
    private int countPairsWithDistanceLessThan(int[] nums, int maxDistance) {
        int count = 0;
        int i = 0;
        int n = nums.length;
        // 使用双指针方法来计算距离
        for (int j = 0; j < n; j++) {
            while (nums[j] - nums[i] > maxDistance) {
                i++; // 移动左指针直到距离小于等于maxDistance
            }
            count += j - i; // 累计符合条件的对数
        }
        return count;
    }
}
