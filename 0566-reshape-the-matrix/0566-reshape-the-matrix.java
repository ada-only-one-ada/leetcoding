class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        int total = mat.length * mat[0].length;

        if (r * c != total) return mat;
        int count = 0;

        int resRow = 0;
        int resCol = 0;

        int matRow = 0;
        int matCol = 0;

        while (count < total) {
            res[resRow][resCol] = mat[matRow][matCol];
            count++;

            if (resCol == c - 1) {
                resRow++;
                resCol = 0;
            } else {
                resCol++;
            }

            if (matCol == mat[0].length - 1) {
                matRow++;
                matCol = 0;
            } else {
                matCol++;
            }
        }

        return res;
    }
}