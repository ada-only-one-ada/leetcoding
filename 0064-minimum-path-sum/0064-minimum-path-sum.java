class Solution {
    public int minPathSum(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;

        int[][] dp = new int[rowNum][colNum];
        dp[0][0] = grid[0][0];

        for (int row = 1; row < rowNum; row++) {
            dp[row][0] = dp[row-1][0] + grid[row][0];
        }

        for (int col = 1; col < colNum; col++) {
            dp[0][col] = dp[0][col-1] + grid[0][col];
        }

        for (int row = 1; row < rowNum; row++) {
            for (int col = 1; col < colNum; col++) {
                dp[row][col] = Math.min(dp[row-1][col], dp[row][col-1]) + grid[row][col];
            }
        }

        return dp[rowNum-1][colNum-1];
    }
}