class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int row = grid.size();
        int col = grid.get(0).size();     

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return b[2] - a[2];
        });   
       
        int[][] maxHealth = new int[row][col];
        for (int[] r : maxHealth) {
            Arrays.fill(r, Integer.MIN_VALUE);
        }

        queue.offer(new int[]{row - 1, col - 1, health - grid.get(row - 1).get(col - 1)});
        maxHealth[row - 1][col - 1] = health - grid.get(row - 1).get(col - 1);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            int currHealth = curr[2];

            if (currRow == 0 && currCol == 0 && currHealth >= 1) {
                return true;
            }

            for (int[] direction: directions) {
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];

                if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) continue;

                int nextHealth = currHealth - grid.get(nextRow).get(nextCol);
                if (nextHealth <= maxHealth[nextRow][nextCol]) continue;

                queue.offer(new int[]{nextRow, nextCol, nextHealth});
                maxHealth[nextRow][nextCol] = nextHealth;
            }  
        }

        return false;
    }
}

/*
Repeated States: 
Your current implementation does not prevent revisiting a state with a lower health 
than previously visited, which can lead to unnecessary computations. 
You can use a 2D array to track the maximum health with which each cell can be visited. 
If a new path leads to a cell with less or equal health than previously recorded, it can be skipped.
*/