class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n][n];

        for (int[] query: queries) {
            int row1 = query[0], row2 = query[2], col1 = query[1], col2 = query[3];
            diff[row1][col1] += 1;

            if (row2 + 1 < n) diff[row2 + 1][col1] -= 1;
            if (col2 + 1 < n) diff[row1][col2 + 1] -= 1;
            if (row2 + 1 < n && col2 + 1 < n) diff[row2 + 1][col2 + 1] += 1;
        }

        for (int row = 0; row < n; row++) {
            for (int col = 1; col < n; col++) {
                diff[row][col] += diff[row][col - 1];
            }
        }

        for (int col = 0; col < n; col++) {
            for (int row = 1; row < n; row++) {
                diff[row][col] += diff[row - 1][col];
            }
        }

        return diff;
    }
}