class Solution {
    public int minSwaps(int[] nums) {
        // 计算 1 的数量
        int ones = 0;
        for (int num: nums) ones += num;
        // 1 的数量少于2个，不需要交换，直接返回 0
        if (ones <= 1) {
            return 0;
        }

        // 计算 0 的数量
        int zeros = nums.length - ones;
        int res = nums.length;
        // 保存遍历的 1 的数量
        int countOnes = 0;

        // 这个部分跟第一题一样
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            countOnes += nums[right];

            if (right - left + 1 == ones) {
                res = Math.min(res, ones - countOnes);

                countOnes -= nums[left];
                left++;
            }
        }

        // 保存遍历的 0 的数量
        int countZeros = 0;
        left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                countZeros++;
            }

            // 当前窗口的长度等于所有 0 的个数：
            if (right - left + 1 == zeros) {
                // 我们把窗口外面的 0 移进当前窗口的的花费
                // 这样当前窗口就全部是 0，即窗口外全部都是 1 
                // 例子：【1，1，1，0，0，1，0，1，1，0】
                int outsideZeros = zeros - countZeros;
                res = Math.min(res, outsideZeros);

                if (nums[left] == 0) countZeros--;
                left++;
            }
        }

        return res;
    }
}