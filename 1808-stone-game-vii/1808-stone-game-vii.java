class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }

        // Alice 想要最大化 (A - B), Bob 想要最小化 (A - B)
        // 即 Alice 会让自己的分数尽可能大，Bob 分数尽可能小
        // 最小化 (A - B)，即 A越小，B越大，所以 Bob 也会让自己分数尽可能大，Alice 分数尽可能小
        // 定义 dp[start][end] 表示当只考虑 stones[start] 到 stones[end] 这部分数组时，
        // 当前操作玩家（轮到操作的玩家）与另一个玩家之间的最大分数差
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;

                // 拿最左边的石头以后，剩余石头的总和
                int pickLeftSum = prefixSum[end] - prefixSum[start];
                // 拿最左边的石头以后，剩下对手会挑选的最佳石头
                int pickLeftDp = dp[start + 1][end];
                // 当前对手可拿的分数就是：剩余石头的总和 减去 剩下对手会挑选的最佳石头

                int pickRightSum = prefixSum[end - 1] - (start > 0? prefixSum[start - 1] : 0);
                int pickRightDp = dp[start][end - 1];

                dp[start][end] = Math.max(pickLeftSum - pickLeftDp,  pickRightSum - pickRightDp);
            }
        }

        return dp[0][n - 1];
    }
}