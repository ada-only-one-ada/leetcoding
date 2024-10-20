class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int res = 0;
        Set<Integer> visited = new HashSet<>();

        for (int node = 0; node < n; node++) {
            if (!visited.contains(node))  {
                res++; // 增加一组
                dfs(isConnected, node, visited); // 把与这个相连的点都加入visited
            }
        }

        return res;
    }

    public void dfs(int[][] isConnected, int node, Set<Integer> visited) {
        for (int nei = 0; nei < isConnected[0].length; nei++) {
            if (visited.contains(nei)) continue; // 已经加入不必再加

            if (isConnected[node][nei] == 1) { // 如果是相连接的点
                visited.add(nei); // 加入visited
                dfs(isConnected, nei, visited); // 这个nei点再继续dfs
            }
        }
    }
}