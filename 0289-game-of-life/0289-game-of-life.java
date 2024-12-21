class Solution {
    public void gameOfLife(int[][] board) {
        int[][] directions = {{-1,-1}, {-1,0}, {-1,1}, {1,-1}, {1,0}, {1,1}, {0,-1}, {0,1}};

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int sum = 0;
                for (int[] dir: directions) {
                    int neiRow = dir[0] + row;
                    int neiCol = dir[1] + col;
                    if (neiRow >= 0 && neiRow < board.length && neiCol >= 0 && neiCol < board[0].length) {
                        if (board[neiRow][neiCol] == 1 || board[neiRow][neiCol] == 3) {
                            sum++;
                        }
                    }
                }

                // live become dead, set to (3), means previous state was (1) then (0)
                if ((sum < 2 || sum > 3) && board[row][col] == 1) {
                    board[row][col] = 3;
                // dead become live, set to (4), means previous state was (0) then (1)
                } else if (board[row][col] == 0 && sum == 3) {
                    board[row][col] = 4;
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 3) {
                    board[row][col] = 0;
                } else if (board[row][col] == 4) {
                    board[row][col] = 1;
                }
            }
        }
    }
}