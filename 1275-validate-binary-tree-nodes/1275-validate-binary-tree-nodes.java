class Solution {
    /*
      由于 Java 对基本数据类型（如 boolean）是按值传递的，
      所以在 dfs 方法中对 hasCycle 进行的更新在方法返回后不会保持。
      这意味着 dfs 方法中循环检测的逻辑不起作用，因为 hasCycle 变量的更改不会反映在方法外部。
    */
    // boolean hasCycle = false; // put it outside 
    boolean[] visited;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) return false;

        visited = new boolean[n];
        if (!dfs(root, leftChild, rightChild)) return false;

        for (boolean isVisted: visited) {
            if (!isVisted) return false;
        }
        
        return true;
    }

    public boolean dfs(int currNode, int[] leftChild, int[] rightChild) {
        if (visited[currNode]) {
            return false;
        }

        visited[currNode] = true;

        boolean left = true;
        if (leftChild[currNode] != -1) {
            left = dfs(leftChild[currNode], leftChild, rightChild);
        }

        boolean right = true;
        if (rightChild[currNode] != -1) {
            right = dfs(rightChild[currNode], leftChild, rightChild);
        }

        return left & right;
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