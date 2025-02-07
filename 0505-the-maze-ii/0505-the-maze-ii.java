class Solution {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int rowNum = maze.length;
        int colNum = maze[0].length;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        boolean[][] visited = new boolean[rowNum][colNum];
        int[][] minCost = new int[rowNum][colNum];
        for (int[] row: minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minCost[start[0]][start[1]] = 0;

        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int distance = curr[2];

            if (row == destination[0] && col == destination[1]) return distance;

            for (int[] direction: directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                int nextDistance = distance + 1;

                while (nextRow >= 0 && nextRow < rowNum && nextCol >= 0 && nextCol < colNum && maze[nextRow][nextCol] == 0) {
                    nextRow += direction[0];
                    nextCol += direction[1];
                    nextDistance++;
                }

                nextDistance--;
                nextRow -= direction[0];
                nextCol -= direction[1];

                if (!visited[nextRow][nextCol] || nextDistance < minCost[nextRow][nextCol]) {
                    queue.add(new int[]{nextRow, nextCol, nextDistance});
                    visited[nextRow][nextCol] = true; 
                    minCost[nextRow][nextCol] = nextDistance;
                }
            }
        }

        return -1;
    }
}