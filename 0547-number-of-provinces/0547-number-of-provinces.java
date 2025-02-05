class Solution {
    int[] root;
    int[] count;
    public int findCircleNum(int[][] isConnected) {
        root = new int[isConnected.length];
        count = new int[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            root[i] = i;
            count[i] = 1;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int nei = 0; nei < isConnected.length; nei++) {
                if (isConnected[i][nei] == 1) {
                    connect(i, nei);
                }
            }
        }

        for (int i = 0; i < isConnected.length; i++) {
            root[i] = findRoot(i);
        }


        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < root.length; i++) {
            set.add(root[i]);
        }
        return set.size();
    }

    public void connect(int node1, int node2) {
        int root1 = findRoot(node1);
        int root2 = findRoot(node2);

        if (root1 == root2) return;

        if (count[root1] >= count[root2]) {
            root[root2] = root1;
            count[root1] += count[root2];
        } else {
            root[root1] = root2; 
            count[root2] += count[root1];
        }
    }

    public int findRoot(int node) {
        int p = root[node];
        if (root[p] != p) {
            p = findRoot(root[p]);
        }

        return root[p];
    }
}