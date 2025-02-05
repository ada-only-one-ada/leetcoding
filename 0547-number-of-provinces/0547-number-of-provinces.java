class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int res = 0;

        for (int node = 0; node < isConnected.length; node++) {
            for (int nei = 0; nei < isConnected[0].length; nei++) {
                
                
                if (isConnected[node][nei] == 1 && !visited.contains(node)) {
                    res++;
                    dfs(node, isConnected, visited);
                }
            }
        }

        return res;
    }

    public void dfs(int node, int[][] isConnected, Set<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);

        int[] neis = isConnected[node];
        for (int nei = 0; nei < neis.length; nei++) {
            if (node == nei) continue;
            if (isConnected[node][nei] == 1) {
                dfs(nei, isConnected, visited);
            }
        }
    }
}