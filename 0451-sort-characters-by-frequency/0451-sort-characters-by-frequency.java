class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Character> queue = new PriorityQueue<>((a, b) -> {
            return map.get(b) - map.get(a);
        });

        for (char c: map.keySet()) {
            queue.add(c);
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            int freq = map.get(curr);
            for (int i = 0; i < freq; i++) {
                sb.append(curr);
            }
        }

        return sb.toString();
    }
}