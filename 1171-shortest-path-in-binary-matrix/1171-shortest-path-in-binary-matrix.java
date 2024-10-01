class Solution {
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {1,-1}, {-1,1}, {1,1}};
    int[][] memo;
    boolean[][] visited;

    public int shortestPathBinaryMatrix(int[][] grid) {
        // 起点或者终点本身就被blocked住了，直接返回
        if (grid[0][0] == 1 || grid[grid.length -1][grid[0].length - 1] == 1) return -1; 

        // 记录访问过的父母cell
        visited = new boolean[grid.length][grid[0].length];
        // 优化，只有当路径更短的时候才走
        memo = new int[grid.length][grid[0].length];
        for (int[] row: memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        // 走到起点本身占一个cell
        queue.add(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];
                int usedCells = curr[2];

                if (currRow == grid.length - 1 && currCol == grid[0].length - 1) return usedCells;
                if (visited[currRow][currCol] == true) continue;

                for (int [] direction: directions) {
                    int nextRow = currRow + direction[0];
                    int nextCol = currCol + direction[1];
               
                    // 越界不走
                    if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) continue;
                    // 被blocked住不走
                    if (grid[nextRow][nextCol] == 1) continue;
                    // 路径更远不走
                    if (usedCells + 1 > memo[nextRow][nextCol]) continue;
                    queue.add(new int[]{nextRow, nextCol, usedCells + 1});
                }

                visited[currRow][currCol] = true;
                memo[currRow][currCol] = Math.min(usedCells, memo[currRow][currCol]);
            }
        }

        return -1;
    }
}