class Solution {
    public int minPathSum(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int[][] dp = new int[rowNum][colNum];
        
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                // 左上第一个格子，花费是它本身
                if (row == 0 && col == 0) {
                    dp[row][col] = grid[row][col];
                // 第一行，只能由左边走过来
                } else if (row == 0) {
                    dp[row][col] = dp[row][col - 1] + grid[row][col];
                // 第一列，只能由上面走下来
                } else if (col == 0) {
                    dp[row][col] = dp[row - 1][col] + grid[row][col];
                // 其他情况：可以由左边或者上面走下来
                } else {
                    dp[row][col] = Math.min(dp[row][col - 1] + grid[row][col], dp[row - 1][col] + grid[row][col]);
                }
            }
        }

        return dp[rowNum - 1][colNum - 1];
    } 
}