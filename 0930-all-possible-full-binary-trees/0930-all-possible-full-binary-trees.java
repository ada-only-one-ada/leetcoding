class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0) return res;
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        for (int leftSubtreeChildrenNumber = 1; leftSubtreeChildrenNumber < n - 1; leftSubtreeChildrenNumber += 2) {
            int rightSubtreeChildrenNumber = n - 1 - leftSubtreeChildrenNumber;

            List<TreeNode> leftChildren = allPossibleFBT(leftSubtreeChildrenNumber);
            List<TreeNode> rightChildren = allPossibleFBT(rightSubtreeChildrenNumber);

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