class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // only move down or right
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowNum - 1][colNum - 1] == 1) return 0; 

        int[][] dp = new int[rowNum][colNum];
        dp[0][0] = 1;

        for (int row = 1; row < rowNum; row++) {
            dp[row][0] = obstacleGrid[row][0] == 1 || dp[row - 1][0] == 0 ? 0 : 1;
        }

        for (int col = 1; col < colNum; col++) {
            dp[0][col] = obstacleGrid[0][col] == 1 || dp[0][col - 1] == 0 ? 0 : 1;
        }

        for (int row = 1; row < rowNum; row++) {
            for (int col = 1; col < colNum; col++) {
                if (obstacleGrid[row][col] == 1 || (dp[row-1][col] == 0 && dp[row][col - 1] == 0)) {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }

        return dp[rowNum - 1][colNum - 1];
    }
}