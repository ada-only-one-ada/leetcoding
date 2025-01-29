class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] req: prerequisites) {
            int toTake = req[0];
            int mustTake = req[1];

            map.putIfAbsent(toTake, new ArrayList<>());
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

        int totalTook = 0;
        while (!queue.isEmpty()) {
            int currTaking = queue.poll();
            totalTook++;

            List<Integer> canTake = map.get(currTaking);
            if (canTake == null) continue;
            for (int nextTake: canTake) {
                indegree[nextTake]--;

                if (indegree[nextTake] == 0) {
                    queue.add(nextTake);
                }
            }
        }

        if (totalTook == numCourses) return true;
        return false;
    }
}