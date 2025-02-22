class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>(); 

        for (int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            map.putIfAbsent(from, new ArrayList<>());
            map.putIfAbsent(to, new ArrayList<>());
            map.get(from).add(new Pair(to, price));
        }

        if (!map.containsKey(src)) return -1;
        if (!map.containsKey(dst)) return -1;

        Queue<int[]> queue = new LinkedList<>();
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        queue.add(new int[]{src, 1, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int pos = curr[0];
            int stops = curr[1];
            int totalCost = curr[2];

            if (stops < k + 2) {
                for (Pair<Integer, Integer> next: map.get(pos)) {
                    int nextCity = next.getKey();
                    int nextCost = totalCost + next.getValue();

                    if (nextCost >= minCost[nextCity]) continue;
                    minCost[nextCity] = nextCost;
                    queue.add(new int[]{nextCity, stops + 1, nextCost});
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}