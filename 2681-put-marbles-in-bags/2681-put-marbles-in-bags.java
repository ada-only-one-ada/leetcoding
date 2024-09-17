class Solution {
    public long putMarbles(int[] weights, int k) {
        // 要装 k 个袋子，至少要有 k 个球
        if (weights.length < k) return -1;

        // 计算所有中间段分割的成本
        long[] adjSum = new long[weights.length - 1];
        for (int i = 0; i < weights.length - 1; i++) {
            adjSum[i] = weights[i] + weights[i + 1];
        }

        // 按从小到大排序
        Arrays.sort(adjSum);

        // 因为求的是 diff，最大收益和最小收益都包括了开头结尾，抵消了
        long minSum = 0;
        for (int i = 0; i < k - 1; i++) {
            minSum += adjSum[i];
        }
        
        long maxSum = 0;
        for (int i = adjSum.length - 1; i >= adjSum.length - (k - 1); i--) {
            maxSum += adjSum[i];
        }

        return maxSum - minSum;
    }
}