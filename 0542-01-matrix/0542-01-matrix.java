class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rowNum = mat.length;
        int colNum = mat[0].length;

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0) continue;
  
                int minDis = Integer.MAX_VALUE;
                if (row > 0) minDis = Math.min(minDis, mat[row - 1][col]);
                if (col > 0) minDis = Math.min(minDis, mat[row][col - 1]);

                if (minDis != Integer.MAX_VALUE) {
                    mat[row][col] = 1 + minDis;
                } else {
                    mat[row][col] = Integer.MAX_VALUE;
                }
            }
        }

        for (int row = rowNum - 1; row >= 0; row--) {
            for (int col = colNum - 1; col >= 0; col--) {
                if (mat[row][col] == 0) continue;

                int minDis = mat[row][col];
                if (row < rowNum - 1) minDis = Math.min(minDis, mat[row + 1][col]);
                if (col < colNum - 1) minDis = Math.min(minDis, mat[row][col + 1]);

                
                    mat[row][col] = Math.min(1 + minDis, mat[row][col]);
                
            }
        }

        return mat;
    }
}