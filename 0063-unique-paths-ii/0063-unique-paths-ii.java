class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        int[][] dp = new int[rowNum][colNum];

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                } else {
                    if (row > 0 && col > 0) {
                        dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                    } else if (row > 0) {
                        dp[row][col] = dp[row - 1][col];
                    } else if (col > 0){
                        dp[row][col] = dp[row][col - 1];
                    } else {
                        dp[row][col] = 1;
                    }
                } 
            }
        }

        return dp[rowNum - 1][colNum - 1];
    }
}