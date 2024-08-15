class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Add the root value if it's not a leaf node.
        if (!isLeaf(root)) result.add(root.val);

        // Add the left boundary (excluding leaf and root).
        addLeftBoundary(root.left, result);

        // Add leaf nodes.
        addLeaves(root, result);

        // Add the right boundary (excluding leaf and root) in reverse.
        addRightBoundary(root.right, result);

        return result;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.val);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    private void addLeaves(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (isLeaf(node)) res.add(node.val);
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    private void addRightBoundary(TreeNode node, List<Integer> res) {
        List<Integer> tmp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) tmp.add(node.val);
            if (node.right != null) node = node.right;
            else node = node.left;
        }
        // Add in reverse order.
        for (int i = tmp.size() - 1; i >= 0; i--) {
            res.add(tmp.get(i));
        }
    }

    private boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }
}
