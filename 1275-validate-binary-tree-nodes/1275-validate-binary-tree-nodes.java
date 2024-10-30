class Solution {
    boolean hasCycle = false;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) return false;

        boolean[] visited = new boolean[n];

        dfs(root, leftChild, rightChild, visited);
        if (hasCycle) return false;

        for (boolean isVisted: visited) {
            if (!isVisted) return false;
        }
        
        return true;
    }

    public void dfs(int currNode, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (visited[currNode]) {
            hasCycle = true;
            return;
        }
        visited[currNode] = true;

        if (leftChild[currNode] != -1) {
            dfs(leftChild[currNode], leftChild, rightChild, visited);
        }

        if (rightChild[currNode] != -1) {
            dfs(rightChild[currNode], leftChild, rightChild, visited);
        }
    }

    public int findRoot(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> isChildOfOther = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                isChildOfOther.add(leftChild[i]);
            }

            if (rightChild[i] != -1) {
                isChildOfOther.add(rightChild[i]);
            }
        }

        int numOfRoot = 0;
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!isChildOfOther.contains(i)) {
                numOfRoot++;
                root = i;
            }
        }

        if (numOfRoot > 1) return -1;
        return root;
    }
}