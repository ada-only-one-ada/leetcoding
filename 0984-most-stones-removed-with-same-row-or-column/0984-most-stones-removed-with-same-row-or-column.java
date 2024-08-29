class Solution {
    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();

    public int removeStones(int[][] stones) {
        int rowOffset = 10000; // 最大的row和col是10^4

        for (int[] stone: stones) {
            int rowKey = stone[0] + rowOffset;
            int colKey = stone[1];
            parent.putIfAbsent(rowKey, rowKey);
            parent.putIfAbsent(colKey, colKey);
            rank.putIfAbsent(rowKey, 0);
            rank.putIfAbsent(colKey, 0);
        }

        for (int[] stone: stones) {
            connect(stone[0] + rowOffset, stone[1]);
        }

        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(find(stone[0] + rowOffset)); 
            set.add(find(stone[1])); 
        }

        return stones.length - set.size();
    }

    public int find(int stone) {
        int p = parent.get(stone);

        if (parent.get(p) != p) {
            return find(parent.get(p));
        }

        return p;
    }

    public void connect(int i, int j) {
        int pi = find(i);
        int pj = find(j);

        if (pi == pj) return;

        int ranki = rank.get(pi);
        int rankj = rank.get(pj);

        if (ranki >= rankj) {
            rank.put(pi, rank.get(pi) + rank.get(pj));
            parent.put(pj, pi);
        } else {
            rank.put(pj, rank.get(pj) + rank.get(pi));
            parent.put(pi, pj);
        }
    }
}