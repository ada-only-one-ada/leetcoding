class Solution {
    int[] parent;
    int[] rank;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        } 

        for (int node = 0; node < n; node++) {
            for (int i = 0; i < n; i++) {
                if (i == node) continue;
                if (isConnected[node][i] == 1) {
                    connect(node, i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            parent[i] = findParent(i);     
        } 

        Set<Integer> uniqueParents = new HashSet<>();
        for (int p: parent) {
            uniqueParents.add(p);
            System.out.println(p);
        }

        return uniqueParents.size();
    }

    public void connect(int nodeA, int nodeB) {
        int parentA = findParent(nodeA);
        int parentB = findParent(nodeB);
        if (parentA == parentB) {
            return;
        }

        int rankA = rank[parentA];
        int rankB = rank[parentB];
        if (rankA >= rankB) {
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
            parent[node] = findParent(p);
        }

        return parent[node];
    }
}