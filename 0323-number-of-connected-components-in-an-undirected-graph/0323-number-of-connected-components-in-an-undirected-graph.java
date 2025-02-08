class Solution {
    int[] parent;
    int[] rank;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge: edges) {
            connect(edge[0], edge[1]);
        }

        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            parent[i] = findRoot(parent[i]);
            unique.add(parent[i]);
        }

        return unique.size();
    }

    public void connect(int node1, int node2) {
        int p1 = findRoot(node1);
        int p2 = findRoot(node2);

        if (p1 == p2) return;

        if (rank[p1] >= rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
    }

    public int findRoot(int node) {
        int p = parent[node];

        if (p != parent[p]) {
            parent[p] = findRoot(p); 
        }

        return parent[p];
    }
}