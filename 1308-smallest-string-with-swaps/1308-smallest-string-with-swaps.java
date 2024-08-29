class Solution {
    int[] rank;
    int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        rank = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (List<Integer> pair: pairs) {
            connect(pair.get(0), pair.get(1));
        }

        // Group all characters by their root parent
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = find(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).add(s.charAt(i));
        }

        // Build the result using the sorted characters in each component
        // 要根据 s 去拿到每个 group 的顺序
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int root = find(i);
            res.append(map.get(root).poll());
        }

        return res.toString();
    }

    public int find(int i) {
        int p = parent[i];

        if (parent[p] != p) {
            parent[p] = find(p);
            return find(p);
        }

        return p;
    }

    public boolean connect(int i1, int i2) {
        int p1 = find(i1);
        int p2 = find(i2);

        if (p1 == p2) return false;

        if (rank[p1] >= rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }
}