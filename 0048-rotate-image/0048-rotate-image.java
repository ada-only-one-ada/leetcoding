class Solution {
    public void rotate(int[][] matrix) {
        /*
        7 8 9
        4 5 6
        1 2 3
        */

        int i = 0;
        int j = matrix.length - 1;
        while (i < j) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;

            i++;
            j--;
        }

        for (int row = 0; row < matrix.length; row++) {
             for (int col = row + 1; col < matrix.length; col++) {
            // for (int col = 0; col < row; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}