class Solution {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rowNum = maze.length;
        int colNum = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowNum][colNum];

        queue.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            if (row == destination[0] && col == destination[1]) return true;

            for (int[] direction: directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                while (nextRow >= 0 && nextRow < rowNum && nextCol >= 0 && nextCol < colNum && maze[nextRow][nextCol] == 0) {
                    nextRow += direction[0];
                    nextCol += direction[1];
                }

                nextRow -= direction[0];
                nextCol -= direction[1];

                if (!visited[nextRow][nextCol]) {
                    queue.add(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true; 
                }
            }
        }

        return false;
    }
}