class Solution {
    public int jump(int[] nums) {
        Queue<int[]> queue = new LinkedList<>();

        Map<Integer, Integer> map = new HashMap<>();

        // start at index 0, cost 0.
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currIndex = curr[0];
            int currCost = curr[1];

            if (currIndex >= nums.length - 1) return currCost;
            for (int i = currIndex + 1; i <= currIndex + nums[currIndex]; i++) {
                if (!map.containsKey(i) || currCost + 1 < map.get(i)) {
                    queue.add(new int[]{i, currCost + 1});
                    map.put(i, currCost + 1);
                }
            }
        }

        return -1;
    }
}