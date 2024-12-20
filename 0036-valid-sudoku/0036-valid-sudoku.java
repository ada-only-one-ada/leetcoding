class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] gridUsed = new boolean[3][3][10];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;

                int num = Character.getNumericValue(board[row][col]);
                if (rowUsed[row][num] || colUsed[col][num] || gridUsed[row/3][col/3][num]) {
                    return false;
                }
                rowUsed[row][num] = true;
                colUsed[col][num] = true;
                gridUsed[row/3][col/3][num] = true;
            }
        }

        return true;
    }
}