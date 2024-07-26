class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rowNum = board.length;
        int colNum = board[0].length;

        boolean[][] rowTaken = new boolean[rowNum][10];
        boolean[][] colTaken = new boolean[colNum][10];
        boolean[][][] gridTaken = new boolean[3][3][10];

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (board[row][col] == '.') continue;
                int num = Character.getNumericValue(board[row][col]);
                if (rowTaken[row][num] || colTaken[col][num] || gridTaken[row/3][col/3][num]) {
                    return false;
                }

                rowTaken[row][num] = true;
                colTaken[col][num] = true;
                gridTaken[row/3][col/3][num] = true;
            }
        }

        return true;
    }
}