class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startCol = 0;
        int endCol = mat[0].length - 1;
        
        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            int maxRow = findMaxInColumn(mat, midCol);
            int maxInMidCol = mat[maxRow][midCol];
            
            int maxInLeftCol = midCol > 0 ? mat[findMaxInColumn(mat, midCol - 1)][midCol - 1] : Integer.MIN_VALUE;
            int maxInRightCol = midCol < mat[0].length - 1 ? mat[findMaxInColumn(mat, midCol + 1)][midCol + 1] : Integer.MIN_VALUE;

            if (maxInLeftCol > maxInMidCol) {
                endCol = midCol - 1;
            } else if (maxInRightCol > maxInMidCol) {
                startCol = midCol + 1;
            } else {
                return new int[]{maxRow, midCol}; // 返回当前中间列的最大值位置
            }
        }

        return new int[]{-1, -1}; // 如果找不到峰值，返回无效索引
    }

    private int findMaxInColumn(int[][] mat, int col) {
        int maxRow = 0;
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > mat[maxRow][col]) {
                maxRow = row;
            }
        }
        return maxRow;
    }
}
