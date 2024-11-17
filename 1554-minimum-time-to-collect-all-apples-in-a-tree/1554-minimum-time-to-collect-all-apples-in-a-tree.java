class Solution {
    Map<Integer, List<Integer>> map;
    boolean[] visited;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];
        return dfs(0, hasApple);
    }

    public int dfs(int node, List<Boolean> hasApple) {
        visited[node] = true;

        int totalCost = 0;
        for (int nei: map.get(node)) {
            if (visited[nei]) continue;
            int subCost = dfs(nei, hasApple);

            if (subCost > 0 || hasApple.get(nei)) {
                totalCost += subCost + 2;
            }
        }

        return totalCost;
    }
}