class Solution {
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return res;
        helper(root, 0);
        return res;
    }

    public void helper(TreeNode root, int currHeight) {
        if (root == null) return;

        // 在新的层级首次访问时添加节点值
        if (currHeight == res.size()) {
            res.add(root.val);
        }

        // 首先尝试遍历右子树
        if (root.right != null) {
            helper(root.right, currHeight + 1);
        }
        // 如果右子树不存在，转向左子树
        if (root.right == null || getHeight(root.left) > getHeight(root.right)) {
            helper(root.left, currHeight + 1);
        }
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
