class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        int rotten = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    fresh++;
                } else if (grid[row][col] == 2) {
                    rotten++;
                    queue.add(new int[]{row, col});
                }
            }
        }

        if (fresh == 0) return 0;
        if (rotten == 0 && fresh != 0) return -1; 

        int minutes = 0;
        while (!queue.isEmpty()) {
            if (fresh == 0) break;
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rottenPos = queue.poll();
                int row = rottenPos[0];
                int col = rottenPos[1];

                for (int[] dir: directions) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) continue;

                    if (grid[nextRow][nextCol] == 1) {
                        queue.add(new int[]{nextRow, nextCol});
                        grid[nextRow][nextCol] = 2;
                        fresh--;
                    }
                }
            }
        }

        if (fresh != 0) return -1;
        return minutes;
    }
}