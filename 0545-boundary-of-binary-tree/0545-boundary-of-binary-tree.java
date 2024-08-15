class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeafNode(root)) res.add(root.val);

        addLeftBoundary(root.left, res);
        addLeafBoundary(root, res);
        addRightBoundary(root.right, res);
        return res;
    }

    public boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    // pre-order traversal: root-left-right
    public void addLeafBoundary(TreeNode node, List<Integer> res) {
        if (node == null) return;

        if (isLeafNode(node)) {
            res.add(node.val);
        }

        addLeafBoundary(node.left, res);
        addLeafBoundary(node.right, res);
    }    

    public void addLeftBoundary(TreeNode node, List<Integer> res) {
        while (node != null) {
            if (!isLeafNode(node)) {
                res.add(node.val);
            }

            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    public void addRightBoundary(TreeNode node, List<Integer> res) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeafNode(node)) {
                temp.add(node.val);
            }

            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }
}