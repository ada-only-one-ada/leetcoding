class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];  // 创建动态规划数组，用于存储到每个索引为止的最大和

        for (int end = 0; end < arr.length; end++) {
            for (int len = 1; len <= k && end - len + 1 >= 0; len++) {
                int start = end - len + 1; // 计算子数组的开始位置
                int max = getMaxValue(arr, start, end); // 调用 getMaxValue 方法获取从 start 到 end 的最大值
                if (start > 0) {
                    // 如果不是数组的第一个元素，加上前一个状态的最大值乘以子数组长度
                    dp[end] = Math.max(dp[end], dp[start - 1] + max * len); 
                } else {
                    // 如果是数组的第一个元素，直接使用当前最大值乘以子数组长度
                    dp[end] = Math.max(dp[end], max * len); 
                }
            }
        }

        return dp[arr.length - 1]; // 返回整个数组的最大划分和
    }

    private int getMaxValue(int[] arr, int start, int end) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = start; i <= end; i++) { 
            maxValue = Math.max(maxValue, arr[i]); 
        }

        return maxValue; 
    }
}