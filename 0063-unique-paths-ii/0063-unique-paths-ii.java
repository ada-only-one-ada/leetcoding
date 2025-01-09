class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        int[][] dp = new int[rowNum][colNum];

        for (int row = rowNum - 1; row >= 0; row--) {               // order matters:
            for (int col = colNum - 1; col >= 0; col--) {
                if (obstacleGrid[row][col] == 1) {                  // 有障碍
                    dp[row][col] = 0;
                } else {                                            // 没障碍
                    if (row == rowNum - 1 && col == colNum - 1){    // 终点
                        dp[row][col] = 1; 
                    } else if (row < rowNum -1 && col < colNum - 1) {
                        dp[row][col] = dp[row + 1][col] + dp[row][col + 1]; // 其他
                    }
                    
                    else if (row == rowNum - 1) {                 // 最后一行
                        dp[row][col] = dp[row][col + 1];
                    } else if (col == colNum - 1) {                 // 最后一列
                        dp[row][col] = dp[row + 1][col];
                    }                     
                }
            }
        }
        
        return dp[0][0];
    }
}