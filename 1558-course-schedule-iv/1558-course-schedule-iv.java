class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // 小岛问题
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] prereq: prerequisites) {
            int mustTake = prereq[0];
            int toTake = prereq[1];
            map.putIfAbsent(mustTake, new HashSet<>());
            map.get(mustTake).add(toTake);
        }

        for (int course = 0; course < numCourses; course++) {
            Set<Integer> allToTakes = new HashSet<>();
            Set<Integer> visited = new HashSet<>();
           
            dfs(course, map, allToTakes, visited);
            map.put(course, allToTakes);
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] q: queries) {
            if (map.containsKey(q[0]) && map.get(q[0]).contains(q[1])) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }

    public void dfs(int course, Map<Integer, Set<Integer>> map, Set<Integer> allToTakes, Set<Integer> visited) {
        if (visited.contains(course)) return;
        visited.add(course);

        if (!map.containsKey(course) || map.get(course).size() == 0) return;

        for (int nei: map.get(course)) {
            allToTakes.add(nei);
            dfs(nei, map, allToTakes, visited);
        }
    }
}