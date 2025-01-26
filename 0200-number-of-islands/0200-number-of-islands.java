class Solution {
    public static int numIslands(char[][] grids) {
        int count = 0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < grids.length; row++) {
            for (int col = 0; col < grids[0].length; col++) {
                char state = grids[row][col];
                
                // an island
                if (state == '1') {
                    // marks as visited
                    grids[row][col] = '1';
                    grids[row][col] = '2';
                    count++;
                    queue.add(new int[]{row, col});
                   
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        
                        for (int[] d: directions) {
                            int nextRow = curr[0] + d[0];
                            int nextCol = curr[1] + d[1];

                            if (nextRow >= 0 && nextRow < grids.length &&
                            nextCol >= 0 && nextCol < grids[0].length) {
                                // find neighbor valid island
                                // will not be counted in the next iteration
                                if (grids[nextRow][nextCol] == '1') {
                                    grids[nextRow][nextCol] = '2';
                                    queue.add(new int[]{nextRow, nextCol});
                                }
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}