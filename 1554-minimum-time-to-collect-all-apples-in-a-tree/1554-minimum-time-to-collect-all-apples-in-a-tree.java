class Solution {
    private static Map<Integer, List<Integer>> graph;
    private static boolean[] visited;

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // 初始化图的邻接表
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        // 填充图
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 访问标志数组
        visited = new boolean[n];

        // 从节点 0 开始执行 DFS
        return dfs(0, hasApple);
    }

    // DFS 方法，返回从当前节点开始需要的最小时间
    private static int dfs(int node, List<Boolean> hasApple) {
        visited[node] = true; // 标记当前节点为已访问
        int totalCost = 0;

        // 遍历当前节点的所有邻居
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) { // 仅访问未被访问的邻居节点
                int subCost = dfs(neighbor, hasApple); // 递归访问邻居

                // subCost > 0
                // subCost 是通过递归调用 dfs(neighbor, hasApple) 得到的，
                // 它代表从当前节点的邻居节点 neighbor 开始，访问其所有子树并收集苹果所需要的时间。
                // 如果 subCost 大于 0，
                // 这意味着从邻居节点 neighbor 到其子节点的路径中至少有一个节点含有苹果。
                // 因此，存在从当前节点到 neighbor 的必要往返行走，以收集这些苹果。

                // hasApple.get(neighbor)
                // 这个条件检查邻居节点 neighbor 本身是否有苹果。
                // 如果 neighbor 有苹果，即使它的子树中没有任何苹果（subCost 为 0），
                // 我们仍然需要从当前节点走到 neighbor 并返回，以收集 neighbor 的苹果。
                if (subCost > 0 || hasApple.get(neighbor)) {
                    // 如果上述任一条件满足，我们就需要将从当前节点到 neighbor 的往返路径成本      
                    // 这行代码将从 neighbor 节点收集苹果所需的时间 加上往返 neighbor 的时间（2秒）。
                    // 这确保了我们计算了整个从当前节点通过 neighbor 收集所有苹果所需的全部时间。
                    totalCost += subCost + 2;
                }
            }
        }

        // 返回总成本
        return totalCost;
    }
}