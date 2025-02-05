class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row: board) {
            Arrays.fill(row, '.');
        }

        backtracking(board, 0, res);
        return res;
    }

    public List<String> copyOneSolution(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row: board) {
            res.add(new String(row));
        }
        return res;
    }

    public void backtracking(char[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            res.add(copyOneSolution(board));
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtracking(board, row + 1, res);
                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        for (int aboveRow = row - 1; aboveRow >= 0; aboveRow--) {
            if (board[aboveRow][col] == 'Q') return false;
        }

        for (int aboveRow = row - 1, leftCol = col - 1; aboveRow >= 0 && leftCol >= 0; aboveRow--, leftCol--) {
            if (board[aboveRow][leftCol] == 'Q') return false;
        }

        for (int aboveRow = row - 1, rightCol = col + 1; aboveRow >= 0 && rightCol < board[0].length; aboveRow--, rightCol++) {
            if (board[aboveRow][rightCol] == 'Q') return false;
        }

        return true;
    }
}