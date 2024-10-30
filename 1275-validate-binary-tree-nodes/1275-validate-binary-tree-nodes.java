class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);

        // 如果没有找到根节点或者有多个根节点，则不是有效的二叉树
        if (root == -1) return false;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            // 如果当前节点已经被访问过，说明存在环，返回false
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