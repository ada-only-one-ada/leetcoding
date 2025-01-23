class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        List<Integer> areas = new ArrayList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    res++;
                    areas.add(dfs(grid, row, col));
                }
            }
        }

        for (int area: areas) {
            System.out.println(area);
        }
        return areas.size();
    }

    public int dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        };

        if (grid[row][col] == '0') {
            return 0;
        }

        grid[row][col] = '0';
        
        return 1 + 
        dfs(grid, row-1, col) + 
        dfs(grid, row+1, col) + 
        dfs(grid, row, col-1) +
        dfs(grid, row, col+1);
    }
}