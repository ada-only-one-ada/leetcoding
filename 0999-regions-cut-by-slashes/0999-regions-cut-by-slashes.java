class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] region = new int[n * 3][n * 3];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char curr = grid[row].charAt(col);

                // 3 x 3 网格
                if (curr == '/') {
                    // 第一行，第三个
                    region[row * 3][col * 3 + 2] = 1;
                    // 第二行，第二个（中间行，中间列）
                    region[row * 3 + 1][col * 3 + 1] = 1;
                    // 第三行，第一个
                    region[row * 3 + 2][col * 3] = 1;
                } else if (curr == '\\') {
                    // 第一行，第一个
                    region[row * 3][col * 3] = 1;
                    // 第二行，第二个（中间行，中间列）
                    region[row * 3 + 1][col * 3 + 1] = 1;
                    // 第三行，第三个
                    region[row * 3 + 2][col * 3 + 2] = 1;
                }
            }
        }

        int res = 0;
        for (int row = 0; row < region.length; row++) {
            for (int col = 0; col < region[0].length; col++) {
                // 1是陆地分界线，0才是岛屿
                if (region[row][col] == 0) {
                    res++;
                    dfs(region, row, col);
                }
            }
        }

        return res;
    }

    public void dfs(int[][] region, int row, int col) {
        if (row < 0 || col < 0 || row == region.length || col == region[0].length) return;
        if (region[row][col] == 1) return;

        region[row][col] = 1;
        dfs(region, row - 1, col);
        dfs(region, row + 1, col);
        dfs(region, row, col - 1);
        dfs(region, row, col + 1);
    }
}
   
