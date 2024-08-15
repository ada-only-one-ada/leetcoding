class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeaf(root)) res.add(root.val);
        addLeftBoundary(root.left, res);
        addLeaf(root, res);
        addRightBoundary(root.right, res);
        return res;
    }

    public boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    // pre-order traversal: root-left-right
    public void addLeftBoundary(TreeNode node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.val);
            }

            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    // pre-order traversal: root-left-right
    public void addLeaf(TreeNode node, List<Integer> res) {
        if (node == null) return;

        if (isLeaf(node)) {
            res.add(node.val);
        }

        addLeaf(node.left, res);
        addLeaf(node.right, res);
    }    

    // pre-order traversal: root-right-left
    public void addRightBoundary(TreeNode node, List<Integer> res) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) {
                temp.add(node.val);
            }

            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        // 先找到的后加入res，所以是reverse加。注意这里不是index 0的位置，可能res前面已经有了其他left，leaf元素了
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }
}