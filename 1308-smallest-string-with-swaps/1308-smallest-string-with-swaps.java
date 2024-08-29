import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Build the graph
        for (List<Integer> pair : pairs) {
            int x = pair.get(0);
            int y = pair.get(1);
            graph[x].add(y);
            graph[y].add(x);
        }

        // To keep track of visited nodes
        boolean[] visited = new boolean[n];
        char[] result = new char[n];
        
        // DFS to find all connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> connectedNodes = new ArrayList<>();
                dfs(graph, visited, connectedNodes, i);
                
                // Extract characters and sort them
                List<Character> characters = new ArrayList<>();
                for (int index : connectedNodes) {
                    characters.add(s.charAt(index));
                }
                Collections.sort(characters);
                
                // Sort indices to place characters correctly
                Collections.sort(connectedNodes);
                for (int j = 0; j < connectedNodes.size(); j++) {
                    result[connectedNodes.get(j)] = characters.get(j);
                }
            }
        }

        return new String(result);
    }

    private void dfs(List<Integer>[] graph, boolean[] visited, List<Integer> connectedNodes, int start) {
        visited[start] = true;
        connectedNodes.add(start);
        for (int neighbor : graph[start]) {
            if (!visited[neighbor]) {
                dfs(graph, visited, connectedNodes, neighbor);
            }
        }
    }
}
