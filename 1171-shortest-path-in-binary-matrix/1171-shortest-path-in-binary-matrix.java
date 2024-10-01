class Solution {
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {1,-1}, {-1,1}, {1,1}};
    int[][] memo;
    boolean[][] visited;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length -1][grid[0].length - 1] == 1) return -1; 

        visited = new boolean[grid.length][grid[0].length];
        memo = new int[grid.length][grid[0].length];

        for (int[] row: memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        queue.add(new int[]{0, 0, 1});
        memo[0][0]= 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            int usedCells = curr[2];

            if (currRow == grid.length - 1 && currCol == grid[0].length - 1) return usedCells;
            if (visited[currRow][currCol] == true) continue;

            for (int [] direction: directions) {
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];
               
                if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) continue;
                if (grid[nextRow][nextCol] == 1) continue;
                if (usedCells + 1 > memo[nextRow][nextCol]) continue;

                queue.add(new int[]{nextRow, nextCol, usedCells + 1});
            }

            visited[currRow][currCol] = true;
            memo[currRow][currCol] = Math.min(usedCells, memo[currRow][currCol]);
        }

        return -1;
    }
}