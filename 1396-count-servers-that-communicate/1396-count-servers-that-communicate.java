class Solution {
    public int countServers(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;

        int[] checkRow = new int[rowNum];
        int[] checkCol = new int[colNum];

        int res = 0;

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (grid[row][col] == 1) {
                    checkRow[row]++;
                    checkCol[col]++;
                }
            }
        }

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (grid[row][col] == 1) {
                    if (checkRow[row] > 1 || checkCol[col] > 1) {
                        res++;
                    }
                }
            }
        }


        return res;
    }
}