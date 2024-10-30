class Solution {
    int[] parent;
    int[] rank;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        parent = new int[n];
        rank = new int[n];
        boolean[] hasParent = new boolean[n];   

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        } 

        for (int i = 0; i < n; i++) {
            int leftChildNode = leftChild[i];
            if (leftChildNode != -1) {
                if (hasParent[leftChildNode]) return false; // Already have a parent
                hasParent[leftChildNode] = true;

                if (!connect(i, leftChildNode)) return false; // Already connected, a circle
            }

            int rightChildNode = rightChild[i];
            if (rightChildNode != -1) {
                if (hasParent[rightChildNode]) return false; // Already have a parent
                hasParent[rightChildNode] = true;

                if (!connect(i, rightChildNode)) return false;
            }
        }

        // find Root ancestor
        int rootAncestor = 0;
        int numberOfRootAncestor = 0;

        for (int i = 0; i < n; i++) {
            if (findAncestor(i) == i) {
                if (numberOfRootAncestor == 1) return false; // We can only have one ancestor that has no parent
                numberOfRootAncestor++;
                rootAncestor = i;
            }
        }

        for (int i = 0; i < n; i++) { // All node have same ancestor
            if (findAncestor(i) != rootAncestor) {
                return false;
            }
        }

        return true;
    }

    public boolean connect(int node1,  int node2) {
        int a1 = findAncestor(node1);
        int a2 = findAncestor(node2);

        if (a1 == a2) return false; // Already connected!

        if (rank[a1] >= rank[a2]) {
            parent[a2] = a1;
            rank[a1] += rank[a2];
        } else {
            parent[a1] = a2;
            rank[a2] += rank[a1];
        }

        return true;
    }

    public int findAncestor(int node) {
        if (node != parent[node]) {
            parent[node] = findAncestor(parent[node]);
        }

        return parent[node];
    }
}