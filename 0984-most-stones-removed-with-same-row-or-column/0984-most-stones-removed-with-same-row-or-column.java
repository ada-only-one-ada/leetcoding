class Solution {
    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();

    public int removeStones(int[][] stones) {
        int rowOffset = 10000; // Offset for rows to differentiate from columns

        // Union on each stone's row and column with different offsets
        for (int[] stone: stones) {
            connect(stone[0] + rowOffset, stone[1]);
        }

        // Count unique roots in union-find structure
        Set<Integer> count = new HashSet<>();
        for (int[] stone : stones) {
            count.add(find(stone[0] + rowOffset));
            count.add(find(stone[1]));
        }

        // 本来一共有10个石头，分成了三堆，那么每堆至少保留一个，总共保留三个
        // 去掉的就是 10 - 3 = 7个，这里求的是去掉的个数
        return stones.length - count.size();
    }

    public int find(int x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            rank.put(x, 1);
        }

        if (x != parent.get(x)) {
            parent.put(x, find(parent.get(x))); 
        }

        return parent.get(x);
    }

    public void connect(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // Union by rank
            if (rank.get(rootX) > rank.get(rootY)) {
                parent.put(rootY, rootX);
            } else if (rank.get(rootX) < rank.get(rootY)) {
                parent.put(rootX, rootY);
            } else {
                parent.put(rootY, rootX);
                rank.put(rootX, rank.get(rootX) + 1);
            }
        }
    }
}