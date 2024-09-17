class Solution {
    public long putMarbles(int[] weights, int k) {
        if (weights.length < k) return -1;

        long[] adjSum = new long[weights.length - 1];
        for (int i = 0; i < weights.length - 1; i++) {
            adjSum[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(adjSum);
        long minSum = weights[0] + weights[weights.length - 1];
        for (int i = 0; i < k - 1; i++) {
            minSum += adjSum[i];
        }

        long maxSum = weights[0] + weights[weights.length - 1];
        for (int i = adjSum.length - 1; i >= adjSum.length - (k - 1); i--) {
            maxSum += adjSum[i];
        }

        return maxSum - minSum;
    }
}