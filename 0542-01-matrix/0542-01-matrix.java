class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rowNum = mat.length;
        int colNum = mat[0].length;
        
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (mat[row][col] == 0) continue;

                int distance = Integer.MAX_VALUE - 1;
                if (row > 0) distance = Math.min(distance, mat[row - 1][col]);
                if (col > 0) distance = Math.min(distance, mat[row][col - 1]);
                mat[row][col] = distance + 1;
            }
        }

        for (int row = rowNum - 1; row >= 0; row--) {
            for (int col = colNum - 1; col >= 0; col--) {
                if (mat[row][col] == 0) continue;

                int distance = mat[row][col];
                if (row < rowNum - 1) distance = Math.min(distance, mat[row + 1][col]);
                if (col < colNum - 1) distance = Math.min(distance, mat[row][col + 1]);
                mat[row][col] = Math.min(mat[row][col], distance + 1);
            }
        }        

        return mat;
    }
}