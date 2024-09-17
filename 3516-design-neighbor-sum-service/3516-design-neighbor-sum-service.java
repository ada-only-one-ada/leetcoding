class NeighborSum {
    Map<Integer, int[]> map = new HashMap<>();
    int[][] adjDirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] diaDirs = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public NeighborSum(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                int value = grid[row][col];
                map.putIfAbsent(value, new int[2]);

                for (int[] adjDir: adjDirs) {
                    int nextRow = row + adjDir[0];
                    int nextCol = col + adjDir[1];
                    if (nextRow < 0 || nextRow >= grid.length) continue;
                    if (nextCol < 0 || nextCol >= grid[0].length) continue;

                    map.get(value)[0] += grid[nextRow][nextCol];
                }

                for (int[] diaDir: diaDirs) {
                    int nextRow = row + diaDir[0];
                    int nextCol = col + diaDir[1];
                    if (nextRow < 0 || nextRow >= grid.length) continue;
                    if (nextCol < 0 || nextCol >= grid[0].length) continue;

                    map.get(value)[1] += grid[nextRow][nextCol];
                }
            }
        }    
    }
    
    public int adjacentSum(int value) {
        return map.get(value)[0];
    }
    
    public int diagonalSum(int value) {
        return map.get(value)[1];
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */