class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    res++;
                    dfs(grid, row, col);
                }
            }
        }
        return res;
    }

    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length) return;
        if (grid[row][col] != '1') return;

        grid[row][col] = '0';
        for (int[] dir: directions) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }
}