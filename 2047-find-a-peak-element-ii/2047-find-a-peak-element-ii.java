class Solution {
    public int[] findPeakGrid(int[][] mat) {int row = 0;
        int startCol = 0;
        int endCol = mat[0].length - 1;
        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            int maxInMidCol = mat[findMaxInColumn(mat, midCol)][midCol];

            int maxInLeftCol = midCol > 0 ? mat[findMaxInColumn(mat, midCol - 1)][midCol - 1]: Integer.MIN_VALUE;
            int maxInRightCol = midCol < mat[0].length - 1? mat[findMaxInColumn(mat, midCol + 1)][midCol + 1] : Integer.MIN_VALUE;

            if (maxInLeftCol > maxInMidCol) {
                endCol = midCol - 1;
            } else if (maxInRightCol > maxInMidCol) {
                startCol = midCol + 1;
            } else {
                return new int[]{findMaxInColumn(mat, midCol), midCol};
            }
        }

        return new int[]{-1, -1};
    }

    public int findMaxInColumn(int[][] mat, int col) {
        int max = Integer.MIN_VALUE;
        int maxRow = -1;
        
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > max) {
                max = mat[row][col];
                maxRow = row;
            }
        }

        return maxRow;
    }
}