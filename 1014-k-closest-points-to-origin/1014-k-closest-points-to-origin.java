class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
        });

        for (int[] point: points) {
            int x = point[0];
            int y = point[1];
            int distance = x * x + y * y;
            queue.add(new int[]{x, y, distance});

            while (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] res = new int[k][2];
        int index = res.length - 1;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            res[index][0] = point[0];
            res[index][1] = point[1];
            index--; 
        }

        return res;
    }
}