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
        // 比如 最大收益：1 3 | 5 | 2，
        //                      7 这里的 7 包括了最后一个2，我们再加一次2即可
        //                  8 这里的 1 只需要加1次，因为结尾是3，8里面包括了

        // 比如 最小收益：1 ｜ 3  5 | 2，
        //                4 这里的4 包括了第一个1，我们再加一次1即可
        
        long maxSum = weights[0] + weights[weights.length - 1];
        for (int i = adjSum.length - 1; i >= adjSum.length - (k - 1); i--) {
            maxSum += adjSum[i];
        }

        System.out.println(minSum);
        System.out.println(maxSum);
        return maxSum - minSum;
    }
}