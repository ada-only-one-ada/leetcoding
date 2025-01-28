class Solution {
    public int orangesRotting(int[][] grid) {
       // if there is not rotten orange, but we have fresh, -1
    int fresh = 0;
    int rotten = 0;

    int minutes = 0;
    Queue<int[]> queue = new LinkedList<>();
    int[][] directions = {{-1,0}, {1,0}, {0, -1}, {0, 1}};

    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[0].length; col++) {
            int currOrange = grid[row][col];
            if (currOrange == 1) {
                fresh++;
            } else if (currOrange == 2) {
                /// we found a rotten orange, we can add it to the queue first 
                rotten++;
                queue.add(new int[]{row, col});
            }
        }
    }

    // edge case:
    // [2,2,2,2]
    if (fresh > 0 && rotten == 0) return -1; 
    
    while (!queue.isEmpty()) {
        // if there is not fresh orange, we quit the affected process.
        if (fresh == 0) break;

        // rotten organge row col index
        int size = queue.size();
        minutes++;

        for (int i = 0; i < size; i++) {
            int[] curr = queue.poll();

            for (int[] direction: directions) {
                int nextRow = curr[0] + direction[0];
                int nextCol = curr[1] + direction[1];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length) {
                    // your neighor is fresh
                    if (grid[nextRow][nextCol] == 1) {
                        fresh--;
                        // turn into rotten
                        grid[nextRow][nextCol] = 2;
                        queue.add(new int[]{nextRow, nextCol});
                    } 
                    // if your neigbor is rotten already, means you are at the same level
                }
            }
        }
    }

    // in the end, if you still have fresh orange, means it is not possible to affect all.
    if (fresh > 0) return -1;

    return minutes;

    // time complexity: O(n^2), space complexity: O(n^2)
    }
}