class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        // 偶数节点不可能构成满二叉树 (包含了零个节点的情况)
        if (n % 2 == 0) return res; 
        // 只有一个根结点，只有一种可能，加入后直接返回
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        // 分给左子树的孩子数量必须是奇数：比如当前根节点的左孩子(1个)，当前根节点的左孙子们(2个)，当前根节点的左孙孙子们(4个)，无论怎么组合都是奇数个
        for (int leftSubtreeChildrenAmout = 1; leftSubtreeChildrenAmout < n - 1; leftSubtreeChildrenAmout += 2) {
            // 剩余要分给右子树的孩子数量：减去 1 是因为根结点 占了一个，再减去左子树的数量
            int rightSubtreeChildrenAmout = n - 1 - leftSubtreeChildrenAmout;

            // 递归生成所有可能的左子树
            List<TreeNode> leftChildren = allPossibleFBT(leftSubtreeChildrenAmout);
            // 递归生成所有可能的右子树
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

        return res;
    }
}