class Solution {
    /*
      由于 Java 对基本数据类型（如 boolean）是按值传递的，
      所以在 dfs 方法中对 hasCycle 进行的更新在方法返回后不会保持。
      这意味着 dfs 方法中循环检测的逻辑不起作用，因为 hasCycle 变量的更改不会反映在方法外部。
    */
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