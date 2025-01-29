class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int rotten = 0;
        Queue<int[]> queue = new LinkedList<>();
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

        int[][] directions = {{-1,0},{1,0}, {0,-1},{0,1}};
        if (fresh == 0) return 0;
        if (fresh > 0 && rotten == 0) return -1;
        int res = 0;

        while (!queue.isEmpty()) {
            if (fresh == 0) break;
            int size = queue.size();
            res++;

            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();

                for (int[] d: directions) {
                    int nextRow = orange[0] + d[0];
                    int nextCol = orange[1] + d[1];

                    if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length) {
                        if (grid[nextRow][nextCol] == 1) {
                            grid[nextRow][nextCol] = 2;
                            fresh--;
                            queue.add(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }
        }

        return fresh == 0? res : -1;
    }
}