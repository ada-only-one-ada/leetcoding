class Solution {
    long count = 0;
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    int[][][] memo;
    int MOD = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new int[m][n][maxMove + 1];
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return count(m, n, maxMove, startRow, startColumn, 0);
    }

    public int count(int m, int n, int maxMove, int row, int col, int moves) {
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return 1;
            
        }
        if (moves == maxMove) return 0;

        if (memo[row][col][moves] != -1) return memo[row][col][moves];

        long total = 0;
        for (int[] dir: directions) {
            int nextRow = dir[0] + row;
            int nextCol = dir[1] + col;

            total = (total + count(m, n, maxMove, nextRow, nextCol, moves + 1)) % MOD;
        }

        memo[row][col][moves] = (int)total;
        return (int)total;
    }
}