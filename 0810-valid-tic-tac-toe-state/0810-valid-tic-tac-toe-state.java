class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] rowCount = new int[3];
        int[] colCount = new int[3];
        int diagonal = 0;
        int anti_diagonal = 0;

        int player1 = 0; // 记录玩家一移动的次数
        int player2 = 0; // 记录玩家二移动的次数

        int winPlayer1 = 0; // 记录玩家一赢的次数
        int winPlayer2 = 0; // 记录玩家二赢的次数

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char curr = board[row].charAt(col); // 当前格子
                if (curr == ' ') continue; // 是空的，跳过

                int direction = curr == 'X' ? 1 : -1; // 玩家一的方向是 1， 玩家二的方向是 -1
                if (direction == 1) player1++; // 玩家一的回合，玩家一移动的次数 + 1
                else if (direction == -1) player2++; // 玩家二的回合，玩家二移动的次数 + 1

                rowCount[row] += direction; // 更新当前 row 总sum
                colCount[col] += direction; // 更新当前 col 总sum
                if (row == col) diagonal += direction; // 更新 diagonal 总sum
                if (row + col + 1 == 3) anti_diagonal += direction; // 更新 anti_diagonal 总sum

                // 判断输赢
                if (rowCount[row] == 3 || colCount[col] == 3 || diagonal == 3 || anti_diagonal == 3) {
                    // 方向为正，玩家一赢了
                    winPlayer1++;
                } else if (rowCount[row] == -3 || colCount[col] == -3 || diagonal == -3 || anti_diagonal == -3) {
                    // 方向为负，玩家二赢了
                    winPlayer2++;
                }
                // 不可能两者同时赢，返回 false
                if (winPlayer1 > 0 && winPlayer2 > 0) return false;
            }
        }
        
        // 因为玩家一是先手，所以玩家一的移动次数 大于等于玩家二，大于的话也只能多一步
        // 如果玩家二的移动次数更多，或者玩家一比玩家二多移动了不止一步，返回 false
        if (player2 > player1 || player1 - player2 > 1) return false;
        // 如果玩家一赢了，玩家二就不能继续移动了，所以玩家一会比玩家二多一步
        if (winPlayer1 > 0 && player2 == player1) return false;
        // 如果玩家二赢了，玩家一就不能继续移动了，所以玩家二的步数等于玩家一
        if (winPlayer2 > 0 && player1 != player2) return false;
        
        return true;
    }
}