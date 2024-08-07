class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        Set<String> set = new HashSet<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1' && !set.contains(row + " " + col)) {
                    count++;
                    dfs(grid, row, col, set);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int row, int col, Set<String> set) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if (grid[row][col] == '0') return;
        if (set.contains(row + " " + col)) return;

        set.add(row + " "+ col);
        dfs(grid, row + 1, col, set);
        dfs(grid, row - 1, col, set);
        dfs(grid, row, col + 1, set);
        dfs(grid, row, col - 1, set);
    }
}