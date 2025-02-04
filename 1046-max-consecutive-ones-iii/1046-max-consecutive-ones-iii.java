class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0;

        int zeros = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                res = Math.max(res, right - left + 1);
            } else if (nums[right] == 0) {
                // 可以flip
                if (zeros < k) {
                    // flip
                    zeros++;
                    // 更新结果
                    res = Math.max(res, right - left + 1);
                // 不可以flip，移动左边窗口
                } else if (zeros == k) {
                    while (zeros == k) {
                        if (nums[left] == 0) zeros--;
                        left++;
                    }
                    zeros++;
                    res = Math.max(res, right - left + 1);
                }
            }
        }

        return res;
    }
}