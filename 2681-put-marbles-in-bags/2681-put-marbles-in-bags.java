class Solution {
    public long putMarbles(int[] weights, int k) {
        if (weights.length < k) return -1; // 检查输入是否有效

        // 计算所有相邻元素对的和
        int[] adjSum = new int[weights.length - 1];
        for (int i = 0; i < weights.length - 1; i++) {
            adjSum[i] = weights[i] + weights[i + 1];
        }

        // 对相邻元素对的和进行排序
        Arrays.sort(adjSum);

        // 计算最大的 k-1 个相邻和的总和
        long maxScore = weights[0] + weights[weights.length - 1]; // 初始化为首尾元素的和
        for (int i = adjSum.length - 1; i >= adjSum.length - (k - 1); i--) {
            maxScore += adjSum[i];
        }

        // 计算最小的 k-1 个相邻和的总和
        long minScore = weights[0] + weights[weights.length - 1]; // 初始化为首尾元素的和
        for (int i = 0; i < k - 1; i++) {
            minScore += adjSum[i];
        }

        return maxScore - minScore;
    }
}