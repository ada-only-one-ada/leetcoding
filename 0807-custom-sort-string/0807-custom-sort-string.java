class Solution {
    public String customSortString(String order, String s) {
        // 构建order字典，第一个char的order是0，第二个char的order是1...
        Map<Character, Integer> charToOrder = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            charToOrder.put(order.charAt(i), i);
        }

        // 最后构建的字符，是按照order字典从小到大排序的
        Queue<Pair<Character, Integer>> queue = new PriorityQueue<>((a, b) -> {
            return a.getValue() - b.getValue();
        });

        // 一边遍历一边加未出现的char
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charToOrder.containsKey(c)) {
                res.append(c);
            } else {
                // 比如 abcda，a是2，b是1，c是0，d未出现，a是2
                queue.add(new Pair<>(c, charToOrder.get(c)));
            }
        }

        while (!queue.isEmpty()) {
            res.append(queue.poll().getKey());
        }

        return res.toString();
    }
}