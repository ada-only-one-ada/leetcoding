class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][10];
        boolean[][] colCheck = new boolean[9][10];
        boolean[][][] gridCheck = new boolean[3][3][10];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') continue;
                int val = Character.getNumericValue(board[row][col]);

                if (rowCheck[row][val]) return false;
                if (colCheck[col][val]) return false;
                if (gridCheck[row/3][col/3][val]) return false;

                rowCheck[row][val] = true;
                colCheck[col][val] = true;
                gridCheck[row/3][col/3][val] = true;
            }
        }

        return true;
    }
}