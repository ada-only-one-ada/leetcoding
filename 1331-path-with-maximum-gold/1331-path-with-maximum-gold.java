class Solution {
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] != 0) {
                    res = Math.max(backtracking(grid, row, col), res);
                }
            }
        }

        return res;
    }

    public int backtracking(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) return 0;
        if (grid[row][col] == 0) return 0;

        int temp = grid[row][col];
        grid[row][col] = 0;

        int max = 0;
        for (int[] direction: directions) {
            max = Math.max(max, temp + backtracking(grid, row + direction[0], col + direction[1]));
        }

        grid[row][col] = temp;
        return max;
    }
}