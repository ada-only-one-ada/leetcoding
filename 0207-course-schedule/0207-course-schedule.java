class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 使用图的邻接表表示，存储每个课程的后续课程
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prereq : prerequisites) {
            int toTake = prereq[0]; // 需要完成的课程
            int mustTake = prereq[1]; // 先决条件课程
            graph.computeIfAbsent(mustTake, k -> new ArrayList<>()).add(toTake);
        }

        // visited数组用于标记每个课程的访问状态：0未访问，1正在访问，2已访问完毕
        int[] state = new int[numCourses];

        // 对每个课程进行DFS
        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0) { // 如果未访问
                if (dfs(course, graph, state)) {
                    return false; // 如果检测到环，返回false
                }
            }
        }

        return true; // 所有课程检查完毕，无环，可以完成所有课程
    }

    // DFS方法用于检测环
    private boolean dfs(int course, Map<Integer, List<Integer>> graph, int[] state) {
        if (state[course] == 1) return true; // 如果该课程正在访问中，表明发现了环
        if (state[course] == 2) return false; // 如果该课程已经访问完毕，无需再次访问

        state[course] = 1; // 标记为正在访问

        List<Integer> successors = graph.getOrDefault(course, Collections.emptyList());
        for (int successor : successors) {
            if (dfs(successor, graph, state)) {
                return true; // 递归访问，如果发现环，立即返回true
            }
        }

        state[course] = 2; // 标记为访问完毕
        return false; // 从当前课程出发没有发现环
    }
}
