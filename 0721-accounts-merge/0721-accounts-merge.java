class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts.size() == 0) return res;

        Set<String> emails = new HashSet<>();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (List<String> list: accounts) {
            String name = list.get(0);

            for (int i = 1; i < list.size(); i++) {
                String email = list.get(i);
                emails.add(email);
                emailToName.put(email, name);
                graph.putIfAbsent(email, new HashSet<>());

                if (i == 1) continue;
                graph.get(list.get(i-1)).add(email);
                graph.get(email).add(list.get(i-1));
            }   
        }

        for (String email: emails) {
            if (!visited.contains(email)) {
                visited.add(email);
                List<String> temp = new ArrayList<>();
                temp.add(email);

                dfs(email, graph, visited, temp);

                Collections.sort(temp);
                temp.add(0, emailToName.get(email));
                res.add(temp);
            }
        }
        return res;
    }

    public void dfs(String email, Map<String, Set<String>> graph, Set<String> visited, List<String> temp) {
        for (String nei: graph.get(email)) {
            if (!visited.contains(nei)) {
                temp.add(nei);
                visited.add(nei);
                dfs(nei, graph, visited, temp);
            }
        }
    }
}