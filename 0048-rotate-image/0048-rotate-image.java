class Solution {
    public void rotate(int[][] matrix) {
        int top = 0;
        int down = matrix.length - 1;
        while (top < down) {
            int[] temp = matrix[top];
            matrix[top] = matrix[down];
            matrix[down] = temp;

            top++;
            down--;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}