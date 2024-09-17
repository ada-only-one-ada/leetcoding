class Solution {
    public long putMarbles(int[] weights, int k) {
        // 一共有 k 个 袋子
        // 没有袋子是空的
        // 每个袋子必须放连续的marbles
        // cost是 w[start] + w[end]
        // 求最大cost 和 最小cost 之差

        if (weights.length < k) return -1;

        int[] adjSum = new int[weights.length - 1];

        for (int i = 0; i < weights.length - 1; i++) {
            adjSum[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(adjSum);
       
        long minSum = 0;
        for (int i = 0; i < k - 1; i++) {
            minSum += adjSum[i];
        }

        long maxSum = 0;
        for (int i = adjSum.length - 1; i >= 0 && k > 1; i--) {
            maxSum += adjSum[i];
            k--;
        }
    
       return maxSum - minSum;
    }
}