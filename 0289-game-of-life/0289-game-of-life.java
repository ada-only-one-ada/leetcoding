class Solution {
    public void gameOfLife(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (alive(board, row, col) && board[row][col] == 0) {
                    board[row][col] = 100;
                } else if (!alive(board, row, col) && board[row][col] == 1) {
                    board[row][col] = -1;
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 100) {
                    board[row][col] = 1;
                } else if (board[row][col] == -1) {
                    board[row][col] = 0;
                }
            }
        }
    }

    public boolean alive(int[][] board, int row, int col) {
        int neibor = 0;

        int[][] directions = {{-1,-1},{-1,0},{-1,1},{1,-1},{1,0},{1,1},{0,-1},{0,1}};
        for (int[] direction: directions) {
            int rowNei = row + direction[0];
            int colNei = col + direction[1];
            if (rowNei >= 0 && rowNei < board.length && colNei >= 0 && colNei < board[0].length) {
                if (Math.abs(board[rowNei][colNei]) == 1) neibor++;
            }
        }
        
        if (Math.abs(board[row][col]) == 1) {
            if (neibor < 2) return false;
            if (neibor == 2 || neibor == 3) return true;
            if (neibor > 3) return false;
        } else if (Math.abs(board[row][col]) == 0) {
            if (neibor == 3) return true;
        }

        return false;
    }
}