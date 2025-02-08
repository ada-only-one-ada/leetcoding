class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(i, new HashSet<>());
        }

        int groups = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int key: map.keySet()) {
            if (!visited.contains(key)) {
                queue.add(key);
                visited.add(key);
                groups++;
                
                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int nei: map.get(node)) {
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            queue.add(nei);
                        }
                    }
                }
            }

        }

        return groups;
    }
}