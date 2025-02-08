class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 5个nodes，4条边
        // n nodes，n-1 edges

        if (edges.length != n - 1) return false;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            map.putIfAbsent(from, new HashSet<>());
            map.putIfAbsent(to, new HashSet<>());
            map.get(from).add(to);
            map.get(to).add(from);
        }

        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visitedNodes.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            Set<Integer> neis = map.get(node);
            if (neis == null) continue;

            for (int nei: neis) {
                if (!visitedNodes.contains(nei)) {
                    queue.add(nei);
                    visitedNodes.add(nei);
                }
            }
        }

        return visitedNodes.size() == n;
    }
}