class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]);
        });

        for (int[] point: points) {
            queue.add(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] res = new int[k][2];
        int index = 0;
        while (index < res.length && !queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;
    }
}