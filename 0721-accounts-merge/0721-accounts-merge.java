class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, String> emailToName = new HashMap<>();
        List<String> emails = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Map<String, Set<String>> graph = new HashMap<>();

        for (List<String> account: accounts) {
            String name = account.get(0);
            
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emails.add(email);
                emailToName.put(email, name);

                graph.putIfAbsent(email, new HashSet<>());
                if (i == 1) continue;

                graph.get(email).add(account.get(i-1));
                graph.get(account.get(i-1)).add(email);
            }
        }

        for (String email: emails) {
            if (!visited.contains(email)) {
                List<String> temp = new ArrayList<>();

                dfs(email, graph, visited, temp);

                Collections.sort(temp);
                temp.add(0, emailToName.get(email));
                res.add(temp);
            }
        }

        return res;
    }

    public void dfs(String email, Map<String, Set<String>> graph, Set<String> visited, List<String> temp) {
        if (!visited.contains(email)) {
            visited.add(email);
            temp.add(email);

            for (String nei: graph.get(email)) {
                if (!visited.contains(nei)) {
                    dfs(nei, graph, visited, temp);
                }
            }
        }
    }
}