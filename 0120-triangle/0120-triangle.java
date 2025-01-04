class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 使用一个数组来存储到当前行每个元素的最小路径和
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);  // 初始化最顶部元素

        // 从第二行开始遍历
        for (int row = 1; row < n; row++) {
            // 从右向左更新dp数组，以避免覆盖还未更新的值
            dp[row] = dp[row - 1] + triangle.get(row).get(row);  // 最右侧元素的更新
            for (int col = row - 1; col > 0; col--) {
                dp[col] = Math.min(dp[col - 1], dp[col]) + triangle.get(row).get(col);
            }
            dp[0] = dp[0] + triangle.get(row).get(0);  // 最左侧元素的更新
        }

        // 在dp数组中找到最小值，这就是从顶部到底部的最小路径和
        int minTotal = dp[0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }
}
