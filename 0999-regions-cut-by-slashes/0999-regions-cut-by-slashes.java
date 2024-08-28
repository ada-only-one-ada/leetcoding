class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] region = new int[n * 3][n * 3];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char curr = grid[row].charAt(col);

                if (curr == '/') {
                    region[row*3][col*3+2] = 1;
                    region[row*3+1][col*3+1] = 1;
                    region[row*3+2][col*3] = 1;
                } else if (curr == '\\') {
                    region[row*3][col*3] = 1;
                    region[row*3+1][col*3+1] = 1;
                    region[row*3+2][col*3+2] = 1;
                }
            }
        }

        int res = 0;
        for (int row = 0; row < region.length; row++) {
            for (int col = 0; col < region[0].length; col++) {
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
   
