class Solution {
    int[] parent;
    int[] rank;
    int count;

    public int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        count = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    if (connect(i, j)) {
                        count--;
                    };
                }
            }
        }

        return n - count;
    }

    public int find(int node) {
        if (node != parent[node]) {
            parent[node] = find(parent[node]);
        }

        return parent[node];
    }

    public boolean connect(int x, int y) {
        int parent1 = find(x);
        int parent2 = find(y);

        if (parent1 == parent2) return false;

        if (rank[parent1] >= rank[parent2]) {
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
        } else {
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
        }

        return true;
    }
}