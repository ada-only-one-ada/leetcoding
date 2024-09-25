class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0) return res;
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        for (int leftSubtreeChildrenAmout = 1; leftSubtreeChildrenAmout < n - 1; leftSubtreeChildrenAmout += 2) {
            int rightSubtreeChildrenAmout = n - 1 - leftSubtreeChildrenAmout;

            List<TreeNode> leftChildren = allPossibleFBT(leftSubtreeChildrenAmout);
            List<TreeNode> rightChildren = allPossibleFBT(rightSubtreeChildrenAmout);

            for (TreeNode leftChild: leftChildren) {
                for (TreeNode rightChild: rightChildren) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftChild;
                    root.right = rightChild;
                    res.add(root);
                }
            }
        }

        return res;
    }
}