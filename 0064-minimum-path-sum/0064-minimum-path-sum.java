class Solution {
    public int minPathSum(int[][] grid) {
        // 只能走 down 或者 right  
        // 左上走到右下

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        queue.add(new int[]{0, 0, 0});
        Map<String, Integer> map = new HashMap<>();

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int sum = curr[2];

            if (row == grid.length - 1 && col == grid[0].length - 1) return sum + grid[row][col];
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) continue;
            
            String state = row + " " + col;
            int newSum = sum + grid[row][col];

            if (!map.containsKey(state) || newSum < map.get(state)) {
                queue.add(new int[]{row + 1, col, newSum});
                queue.add(new int[]{row, col + 1, newSum});
                map.put(state, newSum);
            }
        }

        return Integer.MAX_VALUE;
    }
}
