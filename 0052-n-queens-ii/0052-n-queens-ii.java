class Solution {
    public boolean isValid(char[][] board, int row, int col) {
        for (int aboveRow = row - 1; aboveRow >= 0; aboveRow--) {
            if (board[aboveRow][col] == 'Q') {
                return false;
            }
        }

        for (int aboveRow = row - 1, leftCol = col - 1; aboveRow >= 0 && leftCol >= 0; aboveRow--, leftCol--) {
            if (board[aboveRow][leftCol] == 'Q') {
                return false;
            }
        }

        for (int aboveRow = row - 1, rightCol = col + 1; aboveRow >= 0 && rightCol < board[0].length; aboveRow--, rightCol++) {
            if (board[aboveRow][rightCol] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void backtracking(char[][] board, int row) {
        if (row == board.length) {
            res++;
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtracking(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    int res = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }

        backtracking(board, 0);
        return res;
    }
}