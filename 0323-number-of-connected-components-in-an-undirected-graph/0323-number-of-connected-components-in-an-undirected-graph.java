class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        boolean[] visited = new boolean[n];

        for (int node = 0; node < n; node++) {
            // 算法从第一个节点开始遍历，直到最后一个节点
            // 对于每个节点，如果它未被访问过，就执行一次dfs
            if (visited[node] == false) {
                dfs(edges, visited, node);
                res++; // 每当从未访问过的节点开始一次新的DFS时，就发现了一个新的连通分量，因此res加1。
            }  
        }
        
        return res;
    }

    public void dfs(int[][] edges, boolean[] visited, int node) {
        if (visited[node] == true) return;
        visited[node] = true;

        // 遍历所有边，如果当前节点是边的一个端点，并且另一个端点未被访问，就对另一个端点递归执行dfs
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            if (node == from && visited[to] == false) {
                dfs(edges, visited, to);
            }

            if (node == to && visited[from] == false) {
                dfs(edges, visited, from);
            }
        }
    }
}