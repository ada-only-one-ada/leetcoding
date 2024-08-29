class Solution {
    int[] parent;
    int[] rank;
    int count;

    public int removeStones(int[][] stones) {
        parent = new int[stones.length];
        rank = new int[stones.length];
        count = stones.length;

        for (int i = 0; i < stones.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                // 如果 石头i 和 石头j 在同一行/列，连通它们
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    if (connect(i, j)) {
                        // 单独自己的集合少了一个
                        count--;
                    };
                }
            }
        }

        // 本来一共有10个石头，分成了三堆，那么每堆至少保留一个，总共保留三个
        // 去掉的就是 10 - 3 = 7个，这里求的是去掉的个数
        return stones.length - count;
    }

    public int find(int stone) {
        int p = parent[stone];
        if (parent[p] != p) {
            return find(p);
        }

        return p;
    }

    public boolean connect(int i, int j) {
        int pi = find(i);
        int pj = find(j);

        if (pi == pj) return false;

        if (rank[pi] >= rank[pj]) {
            rank[pi] += rank[pj];
            parent[pj] = pi;
        } else {
            rank[pj] += rank[pi];
            parent[pi] = pj;
        }

        return true;
    }
}