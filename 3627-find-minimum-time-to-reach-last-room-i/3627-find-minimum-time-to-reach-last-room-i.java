class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int minTimeToReach(int[][] moveTime) {
        // 题目的意思是，在这个时间以后，才能到这个房间来。
        // 0   1
        // 1   2

        int rowNum = moveTime.length;
        int colNum = moveTime[0].length;
        if (rowNum == 0 || colNum == 0) return 0;

        boolean[][] seen = new boolean[rowNum][colNum];

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        queue.add(new int[]{0, 0, 0});
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currTime = curr[2];

            if (currX == rowNum - 1 && currY == colNum - 1) {
                return currTime;
            }

            if (seen[currX][currY]) continue;
            seen[currX][currY] = true;

            for (int[] dir: directions) {
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if (nextX < 0 || nextX >= rowNum || nextY < 0 || nextY >= colNum) continue;

                queue.add(new int[]{
                    nextX, nextY,
                    Math.max(currTime + 1, moveTime[nextX][nextY] + 1),
                });
            }
        }

        return -1;
    }
}