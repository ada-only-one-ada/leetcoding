class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];

        for (int[] req: prerequisites) {
            int toTake = req[0];
            int mustTake = req[1];

            map.putIfAbsent(mustTake, new ArrayList<>());
            map.get(mustTake).add(toTake);
            indegree[toTake]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int currTaking = queue.poll();
            res[index++] = currTaking;

            if (!map.containsKey(currTaking) || map.get(currTaking) == null) continue;
            for (int nextTaking: map.get(currTaking)) {
                indegree[nextTaking]--;
                if (indegree[nextTaking] == 0) {
                    queue.add(nextTaking);
                }
            }
        }

        if (index < numCourses) return new int[0];
        return res;
    }
}