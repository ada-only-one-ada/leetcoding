class Solution {
    public int minFlips(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;

        int[] dpRow = new int[rowNum];
        int minRow = 0;

        for (int row = 0; row < rowNum; row++) {
            int change = 0;
            int leftCol = 0;
            int rightCol = colNum - 1;
            while (leftCol < rightCol) {
                if (grid[row][leftCol] != grid[row][rightCol]) {
                    change++;
                }
                leftCol++;
                rightCol--;
            }
            dpRow[row]= change;
            minRow += change;
        }

        int[] dpCol = new int[colNum];
        int minCol = 0;

        for (int col = 0; col < colNum; col++) {
            int change = 0;
            int upRow = 0;
            int downRow = rowNum - 1;
            while (upRow < downRow) {
                if (grid[upRow][col] != grid[downRow][col]) {
                    change++;
                } 
                upRow++;
                downRow--;
            }
            dpCol[col]= change;
            minCol += change;
        }

        return Math.min(minRow, minCol);
    }
}