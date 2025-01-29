class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, word, 0, row, col)) {
                        return true;
                    }
                }
            }
        }   

        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row == board.length || col == board[0].length) {
            return false;
        }

        if (board[row][col] == word.charAt(index)) {
            board[row][col] = '-';

            boolean res = dfs(board, word, index + 1, row - 1, col) || 
            dfs(board, word, index + 1, row + 1, col) ||
            dfs(board, word, index + 1, row, col - 1) ||
            dfs(board, word, index + 1, row, col + 1);

            if (res) return res;
            board[row][col] = word.charAt(index);

        }

        return false;
    }
}