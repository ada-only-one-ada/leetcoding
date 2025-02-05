class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> res = new HashSet<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("o");
                    dfs(grid, row, col, sb);
                    res.add(sb.toString());
                }
            }
        }

        return res.size();
    }

    public void dfs(int[][] grid, int row, int col, StringBuilder sb) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) return;

        if (grid[row][col] == 0) return;

        grid[row][col] = 0;
        dfs(grid, row - 1, col, sb.append("u"));
        dfs(grid, row + 1, col, sb.append("d"));
        dfs(grid, row, col - 1, sb.append("l"));
        dfs(grid, row, col + 1, sb.append("r"));
    }
}