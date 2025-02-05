class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if (node.right != null) {
                    root = node.right;
                }
            }
        }

        return res;
    }
}