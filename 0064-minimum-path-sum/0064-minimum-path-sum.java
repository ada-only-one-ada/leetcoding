class Solution {
    public int minPathSum(int[][] grid) {
        // 只能走 down 或者 right  
        // 左上走到右下
        int[][] directions = new int[][]{{1,0}, {0,1}};

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        queue.add(new int[]{0, 0, grid[0][0]});
        Map<String, Integer> map = new HashMap<>();

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int sum = curr[2];

            if (row == grid.length - 1 && col == grid[0].length - 1) return sum;
            
            for (int[] direction: directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (nextRow >= grid.length || nextCol >= grid[0].length) continue;
                String state = nextRow + " " + nextCol;
                int nextSum = sum + grid[nextRow][nextCol];
                if (map.containsKey(state) && nextSum >= map.get(state)) continue;

                queue.add(new int[]{nextRow, nextCol, nextSum});
                map.put(state, nextSum);
            }
        }

        return Integer.MAX_VALUE;
    }
}
