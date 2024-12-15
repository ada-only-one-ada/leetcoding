class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] p: prerequisites) {
            int toTake = p[0];
            int mustTake = p[1];

            map.putIfAbsent(mustTake, new HashSet<>());
            map.get(mustTake).add(toTake);
            indegree[toTake]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int currTaking = queue.poll();
            res[index++] = currTaking;

            Set<Integer> set = map.get(currTaking);
            if (set == null) continue;

            for (int nextCourse: set) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        if (index < numCourses) return new int[0];
        return res;
    }
}