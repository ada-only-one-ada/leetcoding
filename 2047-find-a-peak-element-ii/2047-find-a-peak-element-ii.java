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

            if (rightColMax > midColMax) {
                startCol = midCol + 1;
            } else if (leftColMax > midColMax) {
                endCol = midCol;
            } else {
                // 这个顺序不能改，这里return放在以后
                // 确保不错过任何一个局部的峰值
                return new int[]{maxRow, midCol};
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
