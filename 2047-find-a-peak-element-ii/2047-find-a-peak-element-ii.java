class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startCol = 0;
        int endCol = mat[0].length;
        
        while (startCol < endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            int maxRow = findMaxRow(mat, midCol);
            int midColMax = mat[maxRow][midCol];

            // 确保左右是最大的
            int leftCol = midCol - 1;
            int leftColMax = leftCol >= 0? mat[findMaxRow(mat, leftCol)][leftCol] : Integer.MIN_VALUE;

            int rightCol = midCol + 1;
            int rightColMax = rightCol < mat[0].length? mat[findMaxRow(mat, rightCol)][rightCol] : Integer.MIN_VALUE;

            if (midColMax >= leftColMax && midColMax >= rightColMax) {
                return new int[]{maxRow, midCol};
            } else if (rightColMax > midColMax) {
                startCol = midCol + 1;
            } else {
                endCol = midCol;
            } 
        }

        return new int[]{-1, -1};
    }


    // 确保上下是最大的
    public int findMaxRow(int[][] mat, int col) {
        int maxRow = 0;

        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] >= mat[maxRow][col]) {
                maxRow = row;
            }
        }

        return maxRow;
    }
}

/*

55   77    9
56   21    59
68   1     77

*/