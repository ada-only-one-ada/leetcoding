class Solution {
    public int maximalSquare(char[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int res = 0;

        int[][] dp = new int[rowNum][colNum];
        for (int col = 0; col < colNum; col++) {
            if (matrix[0][col] == '1') {
                dp[0][col] = 1;
            }
            res = Math.max(res, dp[0][col]);
        }

        for (int row = 0; row < rowNum; row++) {
            if (matrix[row][0] == '1') {
                dp[row][0] = 1;
            }
            res = Math.max(res, dp[row][0]);
        }
        
        for (int row = 1; row < rowNum; row++) {
            for (int col = 1; col < colNum; col++) {
                if (matrix[row][col] == '1') {
                    int min = Math.min(Math.min(dp[row-1][col], dp[row][col-1]), dp[row-1][col-1]);
                    dp[row][col] = min + 1;
                }
                res = Math.max(res, dp[row][col]);
            }
        }

        return res * res;
    }
}