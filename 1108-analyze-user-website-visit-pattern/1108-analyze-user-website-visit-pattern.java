class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        String[][] tuples = new String[username.length][3];
        for (int i = 0; i < username.length; i++) {
            tuples[i][0] = username[i];
            tuples[i][1] = String.valueOf(timestamp[i]);
            tuples[i][2] = website[i];
        }

        Arrays.sort(tuples, (a, b) -> Integer.valueOf(a[1]).compareTo(Integer.valueOf(b[1])));
        Map<String, List<String>> map = new HashMap<>();
        for (String[] tuple: tuples) {
            String user = tuple[0];
            String web = tuple[2];

            map.putIfAbsent(user, new ArrayList<>());
            map.get(user).add(web);
        }

        Map<String, Integer> patterns = new HashMap<>();
        for (String key: map.keySet()) {
            backtracking(map.get(key), 0, "", 0, patterns, new HashSet<>());
        }

        List<String> possibleRes = new ArrayList<>();
        int max = 0;

        for (String p: patterns.keySet()) {            
            if (patterns.get(p) > max) {
                possibleRes.clear();
                possibleRes.add(p.substring(1));
                max = patterns.get(p);
            } else if (patterns.get(p) == max){
                possibleRes.add(p.substring(1));
            }
        }

        Collections.sort(possibleRes);
        return Arrays.asList(possibleRes.get(0).split("-"));
    }

    public void backtracking(List<String> websites, int index, String currRes, int count, Map<String, Integer> patterns, HashSet<String> visited) {
        if (index == websites.size() || count == 3) {
            if (count == 3 && !visited.contains(currRes)) {
                patterns.put(currRes, patterns.getOrDefault(currRes, 0) + 1);
            }
            visited.add(currRes);
            return;
        }

        for (int i = index; i < websites.size(); i++) {
            backtracking(websites, i + 1, currRes + "-" + websites.get(i), count + 1, patterns, visited);
        }
    }
}