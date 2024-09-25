class Solution {
    Map<Integer, List<TreeNode>> paths = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0) return res; 
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        if (paths.containsKey(n)) {
            return paths.get(n);
        }

        for (int leftSubtreeChildrenAmout = 1; leftSubtreeChildrenAmout < n - 1; leftSubtreeChildrenAmout += 2) {
            int rightSubtreeChildrenAmout = n - 1 - leftSubtreeChildrenAmout;

            List<TreeNode> leftChildren = allPossibleFBT(leftSubtreeChildrenAmout);
            List<TreeNode> rightChildren = allPossibleFBT(rightSubtreeChildrenAmout);

            for (TreeNode leftChild: leftChildren) {
                for (TreeNode rightChild: rightChildren) {
                    // 为每一种组合创建一个新的根节点
                    TreeNode root = new TreeNode(0);
                    root.left = leftChild;
                    root.right = rightChild;
                    // 添加到结果列表中
                    res.add(root);
                }
            }
        }

        paths.put(n, res);
        return res;
    }
}