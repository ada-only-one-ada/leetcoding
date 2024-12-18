class Solution {
    public void setZeroes(int[][] matrix) {
        // in place
        boolean topLeft = false;
        boolean top = false;
        boolean left = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0 && col == 0) {
                        topLeft = true;
                    } else if (row == 0) {
                        top = true;
                    } else if (col == 0) {
                        left = true;
                    } else {
                        matrix[0][col] = 0;
                        matrix[row][0] = 0;
                    }  
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (topLeft || top || left) {
            if (left || topLeft) {
                for (int row = 0; row < matrix.length; row++) {
                   matrix[row][0] = 0;
                }
            }

            if (top || topLeft) {
                for (int col = 0; col < matrix[0].length; col++) {
                   matrix[0][col] = 0;
                }
            }
        }   
    }
}