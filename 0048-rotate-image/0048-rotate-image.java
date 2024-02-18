class Solution {
    public void rotate(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        while (top < bottom) {
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;
            top++;
            bottom--;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = row+1; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}