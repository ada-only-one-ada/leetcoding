class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
    }

    public int countSmaller(int[][] matrix, int value) {
        int count = 0;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int startRow = 0;
        int endRow = rowNum;
        while (startRow < endRow) {
            int midRow = startRow + (endRow - startRow) / 2;
            
            int startCol = 0;
            int endCol = colNum;
            while (startCol < endCol) {
                int midCol = startCol + (endCol - startCol) / 2;

                if (matrix[midRow][midCol] < value) {
                    count += (midRow * colNum) + midCol;
                    startCol = midCol + 1;
                } else {
                    endCol = midCol;
                }
            }

            
        }

        return count;
    }
}