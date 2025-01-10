class Solution {
    public int jump(int[] nums) {
        // 这里不需要 priority queue，因为每次走都一步，越晚加入的肯定花费越大
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
                int nextCost = currCost + 1;
                // 如果之前没走过，或者这次走的花费更小，才需要更新
                if (!map.containsKey(i) || nextCost < map.get(i)) {
                    queue.add(new int[]{i, nextCost});
                    map.put(i, nextCost);
                }
            }
        }

        return -1;
    }
}