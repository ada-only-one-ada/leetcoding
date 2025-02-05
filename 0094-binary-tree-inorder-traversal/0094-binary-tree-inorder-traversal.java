class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                res.add(node.val);
                if (node.right != null) {
                    root = node.right;
                }
           }
        }
        return res;
    }
}