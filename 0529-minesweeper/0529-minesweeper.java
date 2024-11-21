class Solution {
    int[][] directions = {{-1,-1}, {-1,0}, {-1,1}, {1,-1}, {1,0}, {1,1}, {0,-1}, {0,1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        
        // 点到 M，踩雷了，更新为X，游戏结束
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        // dfs处理board
        dfs(board, row, col);
        return board;
    }

    public void dfs(char[][] board, int row, int col) {
        // 不是unrevealed的，返回。
        if (board[row][col] != 'M' && board[row][col] != 'E') return;
        
        // 第一种情况：点到 M，踩雷了，更新为X，游戏结束
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return;
        }

        // 第二种情况：点到 E，空地，又分两种情况。要统计8个邻居的雷数。
        int adjacentMines = 0;
        for (int[] dir: directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (nextRow < 0 || nextCol < 0 || nextRow >= board.length || nextCol >= board[0].length) continue;
            if (board[nextRow][nextCol] == 'M') adjacentMines++;
        }

        // 1. 周围 8 个格子有雷，更新为雷数，返回。
        if (adjacentMines > 0) {
            board[row][col] = (char)(adjacentMines + '0');
            return;
        // 2. 周围 8 个格子没有雷，更新为 B，并继续递归探测这 8 个格子。
        } else {
            board[row][col] = 'B';
            for (int[] dir: directions) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                if (nextRow < 0 || nextCol < 0 || nextRow >= board.length ||nextCol >= board[0].length) continue;

                dfs(board, nextRow, nextCol);
            }
        }
    }
}