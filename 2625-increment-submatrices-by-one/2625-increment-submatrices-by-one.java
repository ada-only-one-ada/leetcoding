class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] grid = new int[n][n];

        for (int[] query: queries) {
            for (int row = query[0]; row <= query[2]; row++) {
                for (int col = query[1]; col <= query[3]; col++) {
                    grid[row][col] += 1;
                }
            }
        }

        return grid;
    }
}