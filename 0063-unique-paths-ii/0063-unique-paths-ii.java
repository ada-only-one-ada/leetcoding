class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 只能向下或者向右移动
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        // 如果起点或者终点就是有障碍物的，直接返回0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowNum - 1][colNum - 1] == 1) return 0; 

        int[][] dp = new int[rowNum][colNum];
        // 到达起点的位置的方式有一种
        dp[0][0] = 1;
        
        // 第一列，看上方是否有障碍物，或者自己本身是不是障碍物，没有就是一种
        for (int row = 1; row < rowNum; row++) {
            dp[row][0] = obstacleGrid[row][0] == 1 || dp[row - 1][0] == 0 ? 0 : 1;
        }

        // 第一行，看左边是否有障碍物，或者自己本身是不是障碍物，没有就是一种
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