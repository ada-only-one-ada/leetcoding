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
                
                if (isConnected[node][nei] == 1) {
                    connect(node, nei);
                }
            }
        }

        for (int node = 0; node < n; node++) {
            parent[node] = findParent(node);
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