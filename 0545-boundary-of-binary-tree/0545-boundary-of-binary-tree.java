class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (!isLeaf(root)) res.add(root.val); // 根节点先加

        addLeftBoundary(root.left, res); // 加入左边界list
        addLeave(root, res); // 加入叶子边界list
        addRightBoundary(root.right, res); // 加入右边界list
        return res; 
    }

    public boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    // pre-order：根-左-右
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

    // pre-order：根-右-左，先找到的后加入，逆序
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

    // pre-order：根-左-右
    public void addLeave(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (isLeaf(node)) res.add(node.val);

        addLeave(node.left, res);
        addLeave(node.right, res);   
    }
}