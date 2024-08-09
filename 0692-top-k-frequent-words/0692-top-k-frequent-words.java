class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String w: words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        Queue<Pair<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getValue() != b.getValue()) {
                return a.getValue() - b.getValue();
            } else {
                return b.getKey().compareTo(a.getKey());
            }
        });

        for (String key: map.keySet()) {
            queue.add(new Pair(key, map.get(key)));
            while (queue.size() > k) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            res.add(0, queue.poll().getKey());
        }

        return res;
    }
}