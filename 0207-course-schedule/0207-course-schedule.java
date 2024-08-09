class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p: prerequisites) {
            int toTake = p[0];
            int mustTake = p[1];
            indegree[toTake]++;
            map.putIfAbsent(toTake, new ArrayList<>());
            map.putIfAbsent(mustTake, new ArrayList<>());
            map.get(mustTake).add(toTake);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int taking = queue.poll();
            List<Integer> nei = map.get(taking);
            if (nei == null) continue;

            for (int n: nei) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    queue.add(n);
                }
            }
        }

        for (int i: indegree) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}