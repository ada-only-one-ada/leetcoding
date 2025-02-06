class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // [0, 1] 
        // to take: 0
        // must take: 1 

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prereq: prerequisites) {
            int toTake = prereq[0];
            int mustTake = prereq[1];
            map.putIfAbsent(mustTake, new ArrayList<>());
            map.get(mustTake).add(toTake);
        }

        int[] state = new int[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0) {
                if (hasCycle(course, map, state)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean hasCycle(int course, Map<Integer, List<Integer>> map, int[] state) {
        if (state[course] == 1) return true; // 如果该课程正在访问中，表明发现了环
        if (state[course] == 2) return false; // 如果该课程已经访问完毕，无需再次访问

        state[course] = 1; // 标记为正在访问

        List<Integer> toTakes = map.get(course);
        if (toTakes != null) {
            for (int toTake: toTakes) {
                if (hasCycle(toTake, map, state)) {
                    return true;
                }
            }
        }

        state[course] = 2; // 标记为访问完毕
        return false;
    }
}