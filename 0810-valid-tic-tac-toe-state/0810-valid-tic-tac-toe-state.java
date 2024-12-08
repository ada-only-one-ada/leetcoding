class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] rowCount = new int[3];
        int[] colCount = new int[3];
        int diagonal = 0;
        int anti_diagonal = 0;

        int player1 = 0;
        int player2 = 0;

        int winPlayer1 = 0;
        int winPlayer2 = 0;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char curr = board[row].charAt(col);
                if (curr == ' ') continue;

                int direction = curr == 'X' ? 1 : -1;
                if (direction == 1) player1++;
                else if (direction == -1) player2++;

                rowCount[row] += direction;
                colCount[col] += direction;
                if (row == col) diagonal += direction;
                if (row + col + 1 == 3) anti_diagonal += direction;

                if (rowCount[row] == 3 || colCount[col] == 3 || diagonal == 3 || anti_diagonal == 3) {
                    winPlayer1++;
                } else if (rowCount[row] == -3 || colCount[col] == -3 || diagonal == -3 || anti_diagonal == -3) {
                    winPlayer2++;
                }
                if (winPlayer1 > 0 && winPlayer2 > 0) return false;
            }
        }

        if (player2 > player1 || player1 - player2 > 1) return false;
        if (winPlayer1 > 0 && player2 == player1) return false;
        if (winPlayer2 > 0 && player1 > player2) return false;
        

        return true;
    }
}