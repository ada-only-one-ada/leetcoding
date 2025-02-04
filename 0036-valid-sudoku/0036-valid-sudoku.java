class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][10];
        boolean[][] colCheck = new boolean[9][10];
        boolean[][][] gridCheck = new boolean[3][3][10];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;

                int num = Character.getNumericValue(board[row][col]);
                if (rowCheck[row][num]) return false;
                if (colCheck[col][num]) return false;
                if (gridCheck[row/3][col/3][num]) return false;

                rowCheck[row][num] = true;
                colCheck[col][num] = true;
                gridCheck[row/3][col/3][num] = true;
            }
        }

        return true;
    }
}