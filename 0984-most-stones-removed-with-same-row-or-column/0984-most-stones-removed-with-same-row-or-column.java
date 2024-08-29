class Solution {
    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();

    // 主要的功能方法，用于移除石头
    public int removeStones(int[][] stones) {
        int rowOffset = 10000; // 行偏移量，用于区分行和列

        // 遍历所有石头，并进行合并操作
        for (int[] stone: stones) {
            connect(stone[0] + rowOffset, stone[1]); // 将行与列连接起来
        }

        // 使用HashSet计算不同的根节点数量，代表不同的连通分量
        Set<Integer> count = new HashSet<>();
        for (int[] stone : stones) {
            count.add(find(stone[0] + rowOffset)); // 找到行的根节点
            count.add(find(stone[1])); // 找到列的根节点
        }

        // 最终结果为总石头数减去连通分量的数量
        // 这表示能够被移除的石头的最大数量
        return stones.length - count.size();
    }

    // 并查集查找方法，带路径压缩优化
    public int find(int x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            rank.put(x, 1);
        }

        if (x != parent.get(x)) {
            parent.put(x, find(parent.get(x)));  // 路径压缩
        }

        return parent.get(x);
    }

    // 并查集合并方法，带按秩合并优化
    public void connect(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // 按秩合并，始终将较小的树合并到较大的树上
            if (rank.get(rootX) > rank.get(rootY)) {
                parent.put(rootY, rootX);
            } else if (rank.get(rootX) < rank.get(rootY)) {
                parent.put(rootX, rootY);
            } else {
                parent.put(rootY, rootX);
                rank.put(rootX, rank.get(rootX) + 1); // 如果秩相同，合并后秩加一
            }
        }
    }
}
