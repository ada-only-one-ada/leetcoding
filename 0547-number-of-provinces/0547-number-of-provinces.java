class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int res = 0;
        Set<Integer> visited = new HashSet<>();

        for (int node = 0; node < n; node++) {
            if (!visited.contains(node))  {
                res++; // 增加一组
                dfs(isConnected, node, visited); // mark这组连起来的点们
            }
        }
        /*
        1 0 0 1
        0 1 1 0
        0 1 1 1
        1 0 1 1
        */

        return res;
    }

    public void dfs(int[][] isConnected, int node, Set<Integer> visited) {
        for (int nei = 0; nei < isConnected[0].length; nei++) {
            if (visited.contains(nei)) continue;

            if (isConnected[node][nei] == 1) {
                visited.add(nei);
                dfs(isConnected, nei, visited);
            }
        }
    }
}