class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] directions = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},{0,1},
            {1,-1},{1,0},{1,1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{click[0], click[1]});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            if (board[row][col] == 'M') {
                board[row][col] = 'X';
                return board;
            } else if (board[row][col] == 'E') {
                int adjacentReveled = 0;
                for (int[] d: directions) {
                    int nextRow = row + d[0];
                    int nextCol = col + d[1];

                    if (nextRow >= 0 && nextCol >= 0 && nextRow < board.length && nextCol < board[0].length) {
                        if (board[nextRow][nextCol] == 'X' || board[nextRow][nextCol] == 'M') {
                            adjacentReveled++;
                        }
                    }
                }

                if (adjacentReveled == 0) {
                    board[row][col] = 'B';
                    for (int[] d: directions) {
                        int nextRow = row + d[0];
                        int nextCol = col + d[1];

                        if (nextRow >= 0 && nextCol >= 0 && nextRow < board.length && nextCol < board[0].length) {
                            queue.add(new int[]{nextRow, nextCol});                
                        }
                    
                    }
                } else {
                    board[row][col] = (char) (adjacentReveled + '0');
                }
            }
        }

        return board;
    }
}