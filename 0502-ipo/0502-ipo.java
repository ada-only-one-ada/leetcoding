class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] capitalProfit = new int[profits.length][2];
        for (int i = 0; i < capitalProfit.length; i++) {
            capitalProfit[i][0] = capital[i];
            capitalProfit[i][1] = profits[i];
        }
        Arrays.sort(capitalProfit, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; //capital from small to big
            return b[1] - a[1]; //if capital is the same, profit from big to small
        });

        Queue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);
        int i = 0;

        while (k > 0) {
            while (i < capitalProfit.length && capitalProfit[i][0] <= w) {
                queue.add(capitalProfit[i]);
                i++;
            }

            if (queue.isEmpty()) break;
            int[] project = queue.poll();
            w += project[1];
            k--;
        }

        return w;
    }
}