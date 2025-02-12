class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int[] res = new int[k];
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });

        for (int key: map.keySet()) {
            queue.add(key);

            while (!queue.isEmpty() &&queue.size() > k) queue.poll();
        }
        int index = k - 1;
        while (!queue.isEmpty()) {
            res[index--] = queue.poll();
        }
        return res;
    }
}