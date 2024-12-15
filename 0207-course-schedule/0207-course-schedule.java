class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] pre: prerequisites) {
            int toTake = pre[0];
            int mustTake = pre[1];

            map.putIfAbsent(mustTake, new HashSet<>());
            map.get(mustTake).add(toTake);
            indegree[toTake]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int finished = 0;
        while (!queue.isEmpty()) {
            int currTaking = queue.poll();
            finished++;

            Set<Integer> set = map.get(currTaking);
            if (set == null) continue;
            for (int nextCourse: set) {
                indegree[nextCourse]--;

                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        return finished == numCourses;
    }
}