class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        // nums = 【2，3，2，1】
        // freq = 【3，2，-3，1】

        // i = 0，3个2加入 【2:3】
        // i = 1，2个3加入 【2:3，3:2】
        // i = 2，3个2移除 【3:2】
        // i = 3，1个1加入 【3:2，1:1】
        
        long[] res = new long[nums.length];
        Map<Integer, Long> map = new HashMap<>();
        Queue<Pair<Integer, Long>> queue = new PriorityQueue<>((a, b) -> {
            return Long.compare(b.getValue(),a.getValue());
        });

        for (int i = 0; i < nums.length; i++) {
            int id = nums[i];
            int change = freq[i];

            map.put(id, map.getOrDefault(id, (long)0) + change);
            while (!queue.isEmpty() && queue.peek().getValue() != map.get(queue.peek().getKey())) {
                queue.poll();
            }
            queue.add(new Pair(id, map.get(id)));
            res[i] = queue.peek().getValue();
        }

        return res;
    }
}