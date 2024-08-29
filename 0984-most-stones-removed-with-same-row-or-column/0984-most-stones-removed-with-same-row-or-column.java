class Solution {
    // 使用两个哈希表存储每个点的父节点和秩
    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();

    public int removeStones(int[][] stones) {
        // 设置一个偏移量来区分行和列的标识
        int rowOffset = 10000; // 最大的row和col是10^4

        // 初始化并查集数据结构
        for (int[] stone : stones) {
            int rowKey = stone[0] + rowOffset; // 行的唯一标识
            int colKey = stone[1]; // 列的唯一标识
            parent.putIfAbsent(rowKey, rowKey);
            parent.putIfAbsent(colKey, colKey);
            rank.putIfAbsent(rowKey, 0);
            rank.putIfAbsent(colKey, 0);
        }

        // 合并每个石头的行和列
        for (int[] stone : stones) {
            connect(stone[0] + rowOffset, stone[1]);
        }

        // 使用一个集合来统计所有不同的根节点，即连通分量的数量
        Set<Integer> set = new HashSet<>();
        for (int stone : parent.keySet()) {
            set.add(find(stone)); // 查找每个节点的根节点
        }

        // 总石头数减去连通分量的数量，即为最大可移除石头数
        return stones.length - set.size();
    }

    // 查找函数，包含路径压缩
    public int find(int stone) {
        int p = parent.get(stone);

        if (parent.get(p) != p) {
            parent.put(stone, find(parent.get(p))); // 路径压缩
            return find(parent.get(p));
        }

        return p;
    }

    // 合并函数，包含按秩合并
    public void connect(int i, int j) {
        int pi = find(i); // 找到i的根节点
        int pj = find(j); // 找到j的根节点

        if (pi == pj) return; // 如果已经在同一集合中，不需要合并

        int ranki = rank.get(pi);
        int rankj = rank.get(pj);

        // 按秩合并，确保树的高度尽可能低
        if (ranki >= rankj) {
            parent.put(pj, pi);
            rank.put(pi, rank.get(pi) + 1); // 只有当高度相同时才更新秩
        } else {
            parent.put(pi, pj);
            rank.put(pj, rank.get(pj) + 1);
        }
    }
}
