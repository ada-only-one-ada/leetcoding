class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (!isLeaf(root)) res.add(root.val);

        addLeftBoundary(root.left, res);
        addLeave(root, res);
        addRightBoundary(root.right, res);
        return res;
    }

    public boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public void addLeftBoundary(TreeNode node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.val);

            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    public void addRightBoundary(TreeNode node, List<Integer> res) {
        List<Integer> reverseList = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) reverseList.add(0, node.val);

            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        for (int val: reverseList) {
            res.add(val);
        }
    }

    public void addLeave(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (isLeaf(node)) res.add(node.val);

        addLeave(node.left, res);
        addLeave(node.right, res);   
    }
}