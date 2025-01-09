class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        int[][] dp = new int[rowNum][colNum];

        for (int row = rowNum - 1; row >= 0; row--) {            
            for (int col = colNum - 1; col >= 0; col--) {
                // 有障碍
                if (obstacleGrid[row][col] == 1) {                  
                    dp[row][col] = 0;
                // 没障碍
                } else {     
                    // 终点                                       
                    if (row == rowNum - 1 && col == colNum - 1){   
                        dp[row][col] = 1; 
                    // 最后一行
                    } else if (row == rowNum - 1) {                 
                        dp[row][col] = dp[row][col + 1];
                    // 最后一列
                    } else if (col == colNum - 1) {                 
                        dp[row][col] = dp[row + 1][col];
                    // 其他
                    } else {
                        dp[row][col] = dp[row + 1][col] + dp[row][col + 1];  
                    }                
                }
            }
        }
        
        return dp[0][0];
    }
}