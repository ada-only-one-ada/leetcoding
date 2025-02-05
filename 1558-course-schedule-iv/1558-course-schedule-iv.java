import java.util.*;

public class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        // Create an adjacency list to represent the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[0], new ArrayList<>());
            graph.get(pre[0]).add(pre[1]);
        }

        // Build the prereqMap using DFS to determine all reachable nodes from each node
        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> visited = new HashSet<>();
            Set<Integer> reachables = new HashSet<>();
            dfs(i, graph, visited, reachables);
            prereqMap.put(i, reachables);
        }

        // Evaluate the queries
        for (int[] query : queries) {
            result.add(prereqMap.getOrDefault(query[0], new HashSet<>()).contains(query[1]));
        }

        return result;
    }

    private void dfs(int current, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> reachables) {
        visited.add(current);
        for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
            reachables.add(neighbor);
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, reachables);
            }
        }
    }
}
