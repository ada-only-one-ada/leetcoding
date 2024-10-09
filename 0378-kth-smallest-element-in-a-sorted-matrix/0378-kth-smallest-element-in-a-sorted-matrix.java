class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int rowStart = 0;
        int rowEnd = rowNum;
        while (rowStart < rowEnd) {
            int rowMid = rowStart + (rowEnd - rowStart) / 2;

            int colStart = 0;
            int colEnd = colNum;
            while (colStart < colEnd) {
                int colMid = colStart + (colEnd - colStart) / 2;
                if (matrix[rowMid][colmid])
            }

        }
    }
}