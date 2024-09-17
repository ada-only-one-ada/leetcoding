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

        // 计算成本最小的 k-1 段，初始值加上了第一个和最后一个的成本
        long minSum = weights[0] + weights[weights.length - 1];
        for (int i = 0; i < k - 1; i++) {
            minSum += adjSum[i];
        }

        // 计算成本最大的 k-1 段，初始值加上了第一个和最后一个的成本
        long maxSum = weights[0] + weights[weights.length - 1];
        for (int i = adjSum.length - 1; i >= adjSum.length - (k - 1); i--) {
            maxSum += adjSum[i];
        }

        return maxSum - minSum;
    }
}