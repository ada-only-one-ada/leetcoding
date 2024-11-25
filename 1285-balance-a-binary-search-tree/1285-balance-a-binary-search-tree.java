class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        return buildTree(list, 0, list.size() - 1);
    }

    public void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    public TreeNode buildTree(List<TreeNode> list, int start, int end) {
        if (start > end) return null;
        if (list.size() == 0) return null;
        if (list.size() == 1) return list.get(0);

        int midIndex = start + (end - start) / 2;
        TreeNode midRoot = list.get(midIndex);

        midRoot.left = buildTree(list, start, midIndex - 1);
        midRoot.right = buildTree(list, midIndex + 1, end);

        return midRoot;
    }
}