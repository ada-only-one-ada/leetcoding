class Solution {
    public void gameOfLife(int[][] board) {
        /*
        live：1
        dead：0

        规则1：周围的1少于2个，这个1死
        规则2：周围的1等于2个或者3个，这个1继续活
        规则3：周围的1大于3个，这个1死
        规则4：周围的1等于3个，这个0活
        */

        int[][] directions = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1}, {0,1},
            {1,-1}, {1, 0}, {1, 1}
        };

        // 原来是0，之后变成1 -> 2
        // 原来是0，之后还是0 -> 3 (可忽略)
        // 原来是1，之后变成0 -> 4
        // 原来是1，之后还是1 -> 5 (可忽略)
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int sum = 0;
                
                for (int[] dir: directions) {
                    int neiRow = row + dir[0];
                    int neiCol = col + dir[1];
                    if (neiRow < 0 || neiCol < 0 || neiRow == board.length || neiCol == board[0].length) continue;

                    if (board[neiRow][neiCol] == 1 || board[neiRow][neiCol] == 4) {
                        sum++;
                    }
                    
                    /*
                    int neiVal = board[neiRow][neiCol];
                    if (neiVal != 0 && neiVal != 1) {
                        if (neiVal == 2 || neiVal == 3) {
                            neiVal = 0;
                        } else if (neiVal == 4 || neiVal == 5) {
                            neiVal = 1;
                        }
                    }
                    sum += neiVal;
                    */
                }

                // 规则1：周围的1少于2个，这个1死
                // 规则2：周围的1等于2个或者3个，这个1继续活 
                // 规则3：周围的1大于3个，这个1死
                // 规则4：周围的1等于3个，这个0活

                // 原来是0，之后变成1 -> 2
                // 原来是0，之后还是0 -> 3 (可忽略)
                // 原来是1，之后变成0 -> 4
                // 原来是1，之后还是1 -> 5 (可忽略)
                if (board[row][col] == 1) {
                    if (sum < 2 || sum > 3) {
                        board[row][col] = 4;
                    } 
                } else if (board[row][col] == 0) {
                    if (sum == 3) {
                        board[row][col] = 2;
                    } 
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 2) {
                    board[row][col] = 1;
                } else if (board[row][col] == 4) {
                    board[row][col] = 0;
                }
            }
        }
    }
}