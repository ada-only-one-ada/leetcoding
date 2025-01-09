class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowNum - 1][colNum - 1] == 1) return 0; 

        int[][] dp = new int[rowNum][colNum];
        

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = 1;
                } else if (row > 0 && col > 0) {
                    if (obstacleGrid[row][col] == 1 || (dp[row-1][col] == 0 && dp[row][col - 1] == 0)) {
                        dp[row][col] = 0;
                    } else {
                        dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                    }
                } else if (row > 0) {
                    dp[row][0] = obstacleGrid[row][0] == 1 || dp[row - 1][0] == 0 ? 0 : 1;
                } else if (col > 0) {
                    dp[0][col] = obstacleGrid[0][col] == 1 || dp[0][col - 1] == 0 ? 0 : 1;
                }
            }
        }

        return dp[rowNum - 1][colNum - 1];
    }
}