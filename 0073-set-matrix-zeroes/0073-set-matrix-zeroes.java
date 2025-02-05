class Solution {
    public void setZeroes(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for (int row = 0; row < rowNum; row++) {
            if (matrix[row][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int col = 0; col < colNum; col++) {
            if (matrix[0][col] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int row = 1; row < rowNum; row++) {
            for (int col = 1; col < colNum; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < rowNum; row++) {
            for (int col = 1; col < colNum; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int row = 0; row < rowNum; row++) {
            if (firstColHasZero) {
                matrix[row][0] = 0;
            }
        }

        for (int col = 0; col < colNum; col++) {
            if (firstRowHasZero) {
                matrix[0][col] = 0;
            }
        }
    }
}