class Solution {
    public void solve(char[][] board) {
        int rowNum = board.length;
        int colNum = board[0].length;

        for (int row = 0; row < rowNum; row++) {
            if (board[row][0] == 'O') dfs(board, row, 0);
            if (board[row][colNum - 1] == 'O') dfs(board, row, colNum - 1);
        }

        for (int col = 0; col < colNum; col++) {
            if (board[0][col] == 'O') dfs(board, 0, col);
            if (board[rowNum - 1][col] == 'O') dfs(board, rowNum - 1, col);
        }
        
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (board[row][col] == '!') {
                    board[row][col] = 'O';
                } else if (board[row][col] != '!') {
                    board[row][col] = 'X';
                }
            }
        }
    }

    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public void dfs(char[][] board, int row, int col) {
        if (row < 0 || row == board.length || col < 0 || col == board[0].length) return;
        if (board[row][col] != 'O') return;

        board[row][col] = '!';
        for (int[] d: directions) {
            dfs(board, row + d[0], col + d[1]);
        }
    }
}