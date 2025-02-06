class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowNum-1][colNum-1] == 1) return 0;

        int[][] dp = new int[rowNum][colNum];
        dp[0][0] = 1;

        for (int col = 1; col < colNum; col++) {
            if (obstacleGrid[0][col] == 1 || dp[0][col - 1] == 0) {
                dp[0][col] = 0;
            } else {
                dp[0][col] = 1;
            }
        }

        for (int row = 1; row < rowNum; row++) {
            if (obstacleGrid[row][0] == 1 || dp[row - 1][0] == 0) {
                dp[row][0] = 0;
            } else {
                dp[row][0] = 1;
            }
        }

        for (int row = 1; row < rowNum; row++) {
            for (int col = 1; col < colNum; col++) {
                int fromTop = dp[row-1][col];
                int fromLeft = dp[row][col-1];

                if (fromTop == 0 && fromLeft == 0 || obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                } else if (fromTop != 0 && fromLeft != 0) {
                    dp[row][col] = fromTop + fromLeft;
                } else if (fromTop != 0) {
                    dp[row][col] = fromTop;
                } else if (fromLeft != 0) {
                    dp[row][col] = fromLeft;
                } 
            }
        }

        return dp[rowNum-1][colNum-1];
    }
}