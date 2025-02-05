class Solution {
    int[] parent;
    int[] rank;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];

        for (int node = 0; node < n; node++) {
            parent[node] = node;
            rank[node] = 1;
        }

        for (int node = 0; node < n; node++) {
            for (int nei = 0; nei < n; nei++) {
                if(node == nei) continue;
                if (isConnected[node][nei] == 1) {
                    connect(node, nei);
                }
            }
        }

        for (int node = 0; node < n; node++) {
            parent[node] = findParent(node);
        }

        Set<Integer> set = new HashSet<>();
        for (int p: parent) {
            set.add(p);
        }
        return set.size();
    }

    public void connect(int node, int nei) {
        int parentA = findParent(node);
        int parentB = findParent(nei);

        if (parentA == parentB) return;

        if (rank[parentA] >= rank[parentB]) {
            parent[parentB] = parentA;
            rank[parentA] += rank[parentB];
        } else {
            parent[parentA] = parentB;
            rank[parentB] += rank[parentA];
        }
    }

    public int findParent(int node) {
        int p = parent[node];
        if (parent[p] != p) {
            parent[p] = findParent(p);
        }

        return parent[p];
    }
}