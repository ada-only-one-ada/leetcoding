class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 每一行从左到右排序
        // 第一个比上一行的最后一个大
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int startRow = 0;
        int endRow = rowNum;
        while (startRow < endRow) {
            int midRow = startRow + (endRow - startRow) / 2;

            int startCol = 0;
            int endCol = colNum;
            int lastNum = -1;
            while (startCol < endCol) {
                int midCol = startCol + (endCol - startCol) / 2;
                if (matrix[midRow][midCol] == target) {
                    return true;
                } else if (matrix[midRow][midCol] > target) {
                    endCol = midCol;
                } else if (matrix[midRow][midCol] < target) {
                    startCol = midCol + 1;
                }
                lastNum = matrix[midRow][midCol];
            }

            if (lastNum < target) {
                startRow = midRow + 1;
            } else if (lastNum > target) {
                endRow = midRow;
            }
        }

        return false;
    }
}