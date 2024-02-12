class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[] maxInCol = new int[matrix[0].length];
        
        for (int col = 0; col < matrix[0].length; col++) {
            int max = Integer.MIN_VALUE;
            for (int row = 0; row < matrix.length; row++) {
                max = Math.max(max, matrix[row][col]);
            }
            maxInCol[col] = max;
        }
        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] != -1) {
                    continue;
                } else {
                    matrix[row][col] = maxInCol[col];
                }
            }
        }
        
        return matrix;
    }
}