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
            connect(pair.get(0), pair.get(1));  // 根据pairs中的配对信息合并集合
        }

        // 将同一集合中的字符根据根节点分类并排序
        // map：<int, pq<char>>
        // root1: pq<child1, child3, child4...>
        // root2: pq<child2, child4>
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = find(i);  // 查找当前元素的根节点
            map.putIfAbsent(root, new PriorityQueue<>());  // 如果没有为根节点创建优先队列，则创建一个
            map.get(root).add(s.charAt(i));  // 将字符添加到对应根节点的优先队列中
        }

        // 构建结果字符串，根据每个节点的根节点信息从对应优先队列中拿出最小字符
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int root = find(i);
            char currSmallest = map.get(root).poll();
            res.append(currSmallest);
        }

        return res.toString();
    }

    public int find(int i) {
        int p = parent[i];

        if (parent[p] != p) {
            parent[p] = find(p);  // 路径压缩，将查找路径上的所有节点的父节点直接指向根节点
            return find(p);
        }

        return p;
    }

    public void connect(int i1, int i2) {
        int p1 = find(i1);
        int p2 = find(i2);

        if (p1 == p2) return;  // 如果两个元素已经在同一集合中，则不需要合并

        // 按rank合并，总是将较小的树作为较大树的子树
        if (rank[p1] >= rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];  // 更新根节点的rank
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
    }
}
