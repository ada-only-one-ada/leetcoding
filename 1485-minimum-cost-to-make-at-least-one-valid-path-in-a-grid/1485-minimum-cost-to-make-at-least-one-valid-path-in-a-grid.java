class Solution {    
    public int minCost(int[][] grid) {
        Map<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{0, 1});
        map.put(2, new int[]{0, -1});
        map.put(3, new int[]{1, 0});
        map.put(4, new int[]{-1, 0});
        
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        queue.add(new int[]{0, 0, 0});

        int[][] visited = new int[grid.length][grid[0].length];
        for (int[] v: visited) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            int currCost = curr[2];

            if (currRow == grid.length - 1 && currCol == grid[0].length - 1) return currCost;

            for (int key: map.keySet()) {
                int[] dir = map.get(key);
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) continue;
        
                if (grid[currRow][currCol] == key) {
                    if (currCost < visited[nextRow][nextCol]) {
                        queue.add(new int[]{nextRow, nextCol, currCost});
                        visited[nextRow][nextCol] = currCost;
                    }
                } else {
                    if (currCost + 1< visited[nextRow][nextCol]) {
                        queue.add(new int[]{nextRow, nextCol, currCost + 1});
                        visited[nextRow][nextCol] = currCost + 1;
                    }
                }
            }
        }

        return grid.length * grid[0].length - 1;
    }
}