class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) return false;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (visited.contains(currNode)) return false;

            int currLeftChild = leftChild[currNode];
            int currRightChild = rightChild[currNode];

            if (currLeftChild != -1) {
                queue.add(currLeftChild);
            }

            if (currRightChild != -1) {
                queue.add(currRightChild);
            }

            visited.add(currNode);
        }

        return visited.size() == n;
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

        int numOfRoot = 0;;
        int root = 0;
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