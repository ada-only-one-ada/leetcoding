class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    res = Math.max(res, dfs(grid, row, col));
                }  
            }
        }

        return res;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) return 0;
        if (grid[row][col] != 1) return 0;

        grid[row][col] = 2;
        return 1 +
        dfs(grid, row - 1, col) + 
        dfs(grid, row + 1, col) + 
        dfs(grid, row, col - 1) + 
        dfs(grid, row, col + 1);   
    }
}